package by.cnb.liferay.portlet.collapsableadvert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import by.cnb.liferay.portlet.collapsableadvert.model.Advert;
import by.cnb.liferay.portlet.collapsableadvert.model.impl.AdvertImpl;
import by.cnb.liferay.portlet.collapsableadvert.service.AdvertLocalService;
import by.cnb.liferay.portlet.collapsableadvert.service.AdvertLocalServiceUtil;

import com.liferay.counter.service.CounterLocalService;
import com.liferay.counter.service.impl.CounterLocalServiceImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.struts.SessionAction;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.WebKeys;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sun.xml.internal.ws.util.StringUtils;

/**
 * Portlet implementation class CollapsableAdvertPortlet
 */
public class CollapsableAdvertPortlet extends MVCPortlet {

	private static Log log = LogFactoryUtil.getLog(CollapsableAdvertPortlet.class);

	private Advert currentAdvert;

	public Advert getCurrentAdvert() {
		return currentAdvert;
	}

	public void setCurrentAdvert(Advert currentAdvert) {
		this.currentAdvert = currentAdvert;
	}

	/**
	 * Sets image path from db
	 */
	@Override
	public void init() throws PortletException {
		super.init();
	}

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		super.doView(renderRequest, renderResponse);

//		int advertsCount = 0;
//		try {
//			advertsCount = AdvertLocalServiceUtil.getAdvertsCount();
//		} catch (SystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		if (advertsCount > 0) {
//			Random rndGen = new Random();
//			int randomAdvertId = rndGen.nextInt(advertsCount);
//			try {
//				currentAdvert = AdvertLocalServiceUtil.getAdvert(randomAdvertId);
////				renderRequest.setAttribute("advert", currentAdvert);
////				Session session = renderRequest.get
//			} catch (PortalException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (SystemException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
	}

	@Override
	public void processAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {

		PortletContext portletContext = actionRequest.getPortletSession()
				.getPortletContext();

//		realPath = portletContext.getRealPath("/images/advert");
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);
		String themeRootPath = themeDisplay.getPathThemeRoot();

		try {
			UploadPortletRequest uploadRequest = PortalUtil
					.getUploadPortletRequest(actionRequest);

			String advertName = uploadRequest.getParameter("advert_name");
			if (advertName != null && !"".equals(advertName) &&
				writeFile("small_img", advertName, themeRootPath, uploadRequest) &&
				writeFile("big_img", advertName, themeRootPath, uploadRequest)) {

//				CounterLocalService counterService = new CounterLocalServiceImpl();
				Advert addedAdvert = new AdvertImpl();

//				addedAdvert.setEntryId(3);
				addedAdvert.setCompanyId(themeDisplay.getCompanyId());
				addedAdvert.setGroupId(themeDisplay.getScopeGroupId());
				addedAdvert.setCreateDate(new Date());
				addedAdvert.setName(advertName);
				addedAdvert.setModifiedDate(new Date());

				AdvertLocalServiceUtil.addAdvert(addedAdvert);
				SessionMessages.add(actionRequest, "save-success");
			} else {
				SessionErrors.add(actionRequest, "save-error");
			}
//			String sourceFileName = uploadRequest.getFullFileName("fileName");

		} catch (Exception e) {
			System.out.println("Exception::::" + e.getMessage());
		}
	}

	private boolean writeFile(String fileName, String advertName,
							String themeRootPath, UploadPortletRequest uploadRequest) {

			boolean result = false;
			byte[] bytes = null;
			File tmpFile = uploadRequest.getFile(fileName);

			try {
				bytes = FileUtil.getBytes(tmpFile);
			} catch (IOException e2) {
				e2.printStackTrace();
				return false;
			}
			File imgFile = null;

			if ((bytes != null) && (bytes.length > 0)) {

				try {
					imgFile = new File("../webapps"+themeRootPath+"images/advert/"+fileName+"_"+advertName+".jpg");
							//+ sourceFileName); html/portlet/collapsable-advert-portlet/images
					FileInputStream fileInputStream = new FileInputStream(tmpFile);
					FileOutputStream fileOutputStream = new FileOutputStream(
							imgFile);
					fileInputStream.read(bytes);
					fileOutputStream.write(bytes, 0, bytes.length);
					fileOutputStream.close();
					fileInputStream.close();
					result = true;
				} catch (FileNotFoundException e) {
					System.out.println("File Not Found.");
					e.printStackTrace();
				} catch (IOException e1) {
					System.out.println("Error Reading The File.");
					e1.printStackTrace();
				}
			}
			return result;
	}
}
