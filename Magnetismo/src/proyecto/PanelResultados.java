package proyecto;
/**
 * Saved as PanelResultados.java
 * @author Kevin Oswaldo Cabrera Navarro A01227157
 * @author Mark Octavio Rivera Acosta A01630250
 * 
 * Started in April 6th, 2016
 * Last modified in April 28th, 2016
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;



@SuppressWarnings("serial")
public class PanelResultados extends JPanel {

	//Boolean to enable the paintComponent() in panelResultados
	private boolean isPainted = false;
	
	private ImageIcon image;
	
	//ImageIcon Array: Saves the circuit images
	private ImageIcon[] imagenes = new ImageIcon[6];
	
	//String: is a resistance, voltage or conductor
	private String componente;
	
	//Double: Electrical current moving through the circuit sections
	private double cable1,
	cable2,
	cable3,
	cable4,
	cable5,
	cable6;
	
	/**
	 * Set the electrical current to specific sections in the circuit
	 * 
	 * @param a set the electrical current to the section a in the circuit
	 * @param b set the electrical current to the section b in the circuit
	 * @param c set the electrical current to the section c in the circuit
	 * @param d set the electrical current to the section d in the circuit
	 * @param e set the electrical current to the section e in the circuit
	 * @param f set the electrical current to the section f in the circuit
	 */
	public void setCables(double a,double b,double c,double d,double e,double f){
		this.cable1=a;
		this.cable2=b;
		this.cable3=c;
		this.cable4=d;
		this.cable5=e;
		this.cable6=f;
	}
	
	/**
	 * Class constructor
	 * Do not receive any parameter
	 * Add a size and background color to the panel
	 */
	public PanelResultados() {
		super();
		this.setPreferredSize(new Dimension(440,680));
		this.setBackground(new Color(251,250,250));
	}

	/**
	 * If button on PanelControles is pressed, paint a new circuit
	 * Set boolean isPainted to false
	 * @param g
	 */
	public void paintComponent(Graphics g){
		if (getIsPainted()) {
			paintCircuit(g);
		}
		this.isPainted = false;
	}

	/**
	 * Draw a new circuit using the size of the electric current 
	 * with identifier colors that represents the size of the charge.
	 * @param g
	 */
	public void paintCircuit(Graphics g) {
		int x = 160;
		int y = 260;
		
		g.drawLine(x, y, x+10, y-20);
		g.drawLine(x+10,y-20,x+30,y+20);
		g.drawLine(x+30,y+20,x+50,y-20);
		g.drawLine(x+50,y-20,x+70,y+20);
		g.drawLine(x+70,y+20,x+90,y-20);
		g.drawLine(x+90,y-20,x+110,y+20);
		g.drawLine(x+110,y+20,x+120,y);

		g.setColor(getColor(this.cable1));
		g.drawLine(60, 60, 160, 60);
		g.drawLine(60, 60, 60, 140);

		g.setColor(getColor(this.cable2));
		g.drawLine(260, 60, 380, 60);
		g.drawLine(380, 60, 380, 140);

		g.setColor(getColor(this.cable3));
		g.drawLine(380, 220, 380, 300);

		g.setColor(getColor(this.cable4));
		g.drawLine(380, 380, 380, 460);
		g.drawLine(380, 460, 260, 460);

		g.setColor(getColor(this.cable5));
		g.drawLine(160, 460, 60, 460);
		g.drawLine(60, 460, 60, 380);

		g.setColor(getColor(this.cable6));
		g.drawLine(60, 300, 60, 220);
		g.drawLine(60, 260, 160, 260);
		g.drawLine(280, 260, 380, 260);
		
		g.drawImage(getImageAr(0).getImage(), 180, 30, 80, 60, null);
		g.drawImage(getImageAr(2).getImage(), 350, 310, 80, 60, null);
		g.drawImage(getImageAr(3).getImage(), 180, 430, 80, 60, null);
		g.drawImage(getImageAr(4).getImage(), 25, 310, 80, 60, null);
		g.drawImage(getImageAr(5).getImage(), 25, 150, 80, 60, null);
		g.drawImage(getImageAr(1).getImage(), 350, 150, 80, 60, null);

	}

	/**
	 * set isPainted to true if JButton BResultado is pressed in PanelControles
	 * @param isPainted
	 */
	public void setPaint(boolean isPainted) {
		this.isPainted = isPainted;
	}
	
	/** 
	 * @return isPainted 
	 * 					return true if the JButton in PanelControles was pressed	
	 */
	public boolean getIsPainted() {
		return this.isPainted;
	}
	
	/**
	 * set an imageIcon to image which will be painted in the circuit
	 * @param image 
	 */
	public void setImage(ImageIcon image){
		this.image = image;
	}
	
	/**
	 * 
	 * @return image
	 * 				return the image that will be painted in the circuit
	 */
	public ImageIcon getImage(){
		return this.image;
	}
	
	/**
	 * Set the kind of component that will be painted in the circuit: resistance, cable or voltage
	 * @param componente
	 */
	public void setComponent(String componente){
		this.componente = componente;
	}
	/**
	 * Returns the kind of component that will be painted in the circuit: resistance, cable or voltage
	 * @return componente
	 */
	public String getComponent(){
		return this.componente;
	}
	/**
	 * Store the images from PanelMalla into an array
	 * @param image: the image that will be stored in the imagenes Array
	 * @param i: The position of the image in the array
	 */
	public void setImagenAr(ImageIcon image, int i){
		this.imagenes[i] = image;
	}
	/**
	 * Get the needed image stored in an specific position in the array imagenes 
	 * @param i: the position of the neccesary image inside the array
	 * @return this.imagenes[i]
	 */
	public ImageIcon getImageAr(int i){
		return this.imagenes[i];
	}

	/**
	 * Creates an electrical current range 
	 * @param corriente
	 * @return color 
	 * 				this color is assigned to the corresponding circuit section 
	 */
	public Color getColor(double corriente){

		Color color = Color.black;

		if (corriente <= 20) {
			color = Color.GREEN;
			
		}else if (corriente > 20 & corriente <= 80) {
			color = new Color(0,100,0);
		
		}else if (corriente > 80 & corriente <= 120) {
			color = new Color(255,255,50);
		
		}else if (corriente > 120 & corriente <= 200) {
			color = new Color(255,128,0);
		
		}else{
			color = Color.RED;
		}
		return color;
	}

}