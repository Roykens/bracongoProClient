/**
 * 
 */
package com.bracongo.clientapi.utils.Exceptions;

/**
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 *
 */
public class PdvException extends MessageBasedException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String BASE_PATH_SERVER_MESSAGE = "";

	protected String getBasePathCatologName() {
		return BASE_PATH_SERVER_MESSAGE;
	}

	public PdvException(String catalogFileName, String messageId) {
		super(catalogFileName, messageId);
	}

	public PdvException(String catalogFileName, String messageId, Object[] aobj) {
		super(catalogFileName, messageId, aobj);
	}

	public PdvException(String catalogFileName, String messageId, Object[] aobj, String detailTechnique) {
		super(catalogFileName, messageId, aobj, detailTechnique);
	}

}
