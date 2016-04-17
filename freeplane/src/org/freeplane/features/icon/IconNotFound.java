package org.freeplane.features.icon;

import java.net.URL;

import javax.swing.ImageIcon;

import org.freeplane.core.resources.ResourceController;

public class IconNotFound extends MindIcon {
	private static final String DEFAULT_IMAGE_PATH = "/images";
	private static final IconNotFound ICON_NOT_FOUND = new IconNotFound();

	public IconNotFound() {
		super("icon_not_found", "IconNotFound.png", "icon not found");
	}

	@Override
	public String getImagePath() {
		return DEFAULT_IMAGE_PATH;
	}

    /**
     * creates an ImageIcon from <code>getImagePath()/filename</code>. If this is not possible returns an IconNotFound.
     */
    public static ImageIcon createIconOrReturnNotFoundIcon(final String fileName) {
        final URL resource = ResourceController.getResourceController()
            .getResource(DEFAULT_IMAGE_PATH + "/" + fileName);
        final ImageIcon icon = (resource == null) ? null : new ImageIcon(resource);
        return icon == null ? (ImageIcon) instance().getIcon() : icon;
    }
    
    /**
     * creates an ImageIcon from <code>getImagePath()/filename</code>. If this is not possible returns null.
     */
    public static ImageIcon createIconOrReturnNull(final String fileName) {
        final URL resource = ResourceController.getResourceController()
                .getResource(DEFAULT_IMAGE_PATH + "/" + fileName);
        return (resource == null) ? null : new ImageIcon(resource);
    }

    public static IconNotFound instance() {
		return ICON_NOT_FOUND;
	}
}
