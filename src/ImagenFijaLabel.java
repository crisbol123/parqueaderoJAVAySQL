import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImagenFijaLabel extends JLabel {
    private Image imagen;

    public ImagenFijaLabel(String imagePath) {
        imagen = new ImageIcon(getClass().getResource(imagePath)).getImage();
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
    }
}