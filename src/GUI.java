import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import java.net.http.WebSocket.Listener;

import javax.swing.JButton;

import java.awt.Color;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.wb.swt.SWTResourceManager;






public class GUI {
	protected Shell shlrdBaseCoach;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private ScrolledComposite scrolledComposite;
	private Button stealBTN;
	private Text seqInput;
	private Button clear;
	private Combo seq1;
	private Text desc1;
	private Combo seq2;
	private Text desc2;
	private Combo seq3;
	private Text desc3;
	private Text text;
	private Combo seq4;
	private Text desc4;
	private Combo seq5;
	private Text desc5;
	private Combo seq6;
	private Text desc6;
	private Combo seq7;
	private Text desc7;
	private Combo seq8;
	private Text desc8;
	private Combo seq9;
	private Text desc9;
	private Combo seq10;
	private Text desc10;
	private Combo seq11;
	private Text desc11;
	private Combo seq12;
	private Text desc12;
	private Combo seq13;
	private Text desc13;
	private Combo seq14;
	private Text desc14;
	private Combo seq15;
	private Text desc15;
	private Combo seq16;
	private Text desc16;
	private Combo seq17;
	private Text desc17;
	private Combo seq18;
	private Text desc18;
	private Combo seq19;
	private Text desc19;
	private Combo seq20;
	private Text desc20;
	private Combo seq21;
	private Text desc21;
	private Combo seq22;
	private Text desc22;
	private Combo seq23;
	private Text desc23;
	private Combo seq24;
	private Text desc24;
	private Combo seq25;
	private Text desc25;
	private Combo seq26;
	private Text desc26;
	private int[] varIndex = new int[26];
	
	
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			GUI window = new GUI();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlrdBaseCoach.open();
		shlrdBaseCoach.layout();
		while (!shlrdBaseCoach.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlrdBaseCoach = new Shell();
		shlrdBaseCoach.setMinimumSize(new Point(1000, 500));
		shlrdBaseCoach.setSize(1000, 496);
		shlrdBaseCoach.setText("3rd Base Coach Predictor");
		
		seqInput = new Text(shlrdBaseCoach, SWT.BORDER);
		seqInput.setBounds(10, 399, 964, 21);
		formToolkit.adapt(seqInput, true, true);
		
		text = new Text(shlrdBaseCoach, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		text.setEditable(false);
		text.setBounds(10, 264, 964, 129);
		formToolkit.adapt(text, true, true);
		
		stealBTN = new Button(shlrdBaseCoach, SWT.NONE);
		stealBTN.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		stealBTN.addMouseListener(new MouseAdapter() {
			String log = "";
			@Override
			public void mouseDown(MouseEvent e) {
				String newLog = "";
				String stealLine = "";
				int index;
				String input = seqInput.getText();
				String[] sequences = input.split(" ");
				for (int i = 0; i < sequences.length; i ++)
				{
					stealLine += sequences[i].toUpperCase();
					try {
						File stealFile = new File ("steal.txt");
						if(i==sequences.length-1)
						{
							stealLine += " 1\n";
							FileWriter writer = new FileWriter("steal.txt");
							writer.write(stealLine.toString());
							writer.close();
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					} finally {
					}
				}
				for (int i = 0; i < sequences.length; i ++)
				{
					sequences[i] = sequences[i].toUpperCase();
					newLog += sequences[i] + ": ";
					switch (sequences[i])
					{
					case "A": index = 0; break;
					case "B": index = 1; break;
					case "C": index = 2; break;
					case "D": index = 3; break;
					case "E": index = 4; break;
					case "F": index = 5; break;
					case "G": index = 6; break;
					case "H": index = 7; break;
					case "I": index = 8; break;
					case "J": index = 9; break;
					case "K": index = 10; break;
					case "L": index = 11; break;
					case "M": index = 12; break;
					case "N": index = 13; break;
					case "O": index = 14; break;
					case "P": index = 15; break;
					case "Q": index = 16; break;
					case "R": index = 17; break;
					case "S": index = 18; break;
					case "T": index = 19; break;
					case "U": index = 20; break;
					case "V": index = 21; break;
					case "W": index = 22; break;
					case "X": index = 23; break;
					case "Y": index = 24; break;
					case "Z": index = 25; break;
					default: index = -1;
					}
					index += 1;
					if (index != 0)
					{
						if (seq1.getSelectionIndex() == index)  { newLog += desc1.getText() + " "; }
						if (seq2.getSelectionIndex() == index)  { newLog += desc2.getText() + " "; }
						if (seq3.getSelectionIndex() == index)  { newLog += desc3.getText() + " "; }
						if (seq4.getSelectionIndex() == index)  { newLog += desc4.getText() + " "; }
						if (seq5.getSelectionIndex() == index)  { newLog += desc5.getText() + " "; }
						if (seq6.getSelectionIndex() == index)  { newLog += desc6.getText() + " "; }
						if (seq7.getSelectionIndex() == index)  { newLog += desc7.getText() + " "; }
						if (seq8.getSelectionIndex() == index)  { newLog += desc8.getText() + " "; }
						if (seq9.getSelectionIndex() == index)  { newLog += desc9.getText() + " "; }
						if (seq10.getSelectionIndex() == index) { newLog += desc10.getText() + " "; }
						if (seq11.getSelectionIndex() == index) { newLog += desc11.getText() + " "; }
						if (seq12.getSelectionIndex() == index) { newLog += desc12.getText() + " "; }
						if (seq13.getSelectionIndex() == index) { newLog += desc13.getText() + " "; }
						if (seq14.getSelectionIndex() == index) { newLog += desc14.getText() + " "; }
						if (seq15.getSelectionIndex() == index) { newLog += desc15.getText() + " "; }
						if (seq16.getSelectionIndex() == index) { newLog += desc16.getText() + " "; }
						if (seq17.getSelectionIndex() == index) { newLog += desc17.getText() + " "; }
						if (seq18.getSelectionIndex() == index) { newLog += desc18.getText() + " "; }
						if (seq19.getSelectionIndex() == index) { newLog += desc19.getText() + " "; }
						if (seq20.getSelectionIndex() == index) { newLog += desc20.getText() + " "; }
						if (seq21.getSelectionIndex() == index) { newLog += desc21.getText() + " "; }
						if (seq22.getSelectionIndex() == index) { newLog += desc22.getText() + " "; }
						if (seq23.getSelectionIndex() == index) { newLog += desc23.getText() + " "; }
						if (seq24.getSelectionIndex() == index) { newLog += desc24.getText() + " "; }
						if (seq25.getSelectionIndex() == index) { newLog += desc25.getText() + " "; }
						if (seq26.getSelectionIndex() == index) { newLog += desc6.getText() + " "; }
						
					}
					
				}
				log += newLog + "\n";
				text.setText(log);
			}
		});
		stealBTN.setBounds(10, 426, 75, 25);
		formToolkit.adapt(stealBTN, true, true);
		stealBTN.setText("Steal");
		
		clear = new Button(shlrdBaseCoach, SWT.NONE);
		clear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				seqInput.setText("");
			}
		});
		clear.setBounds(899, 426, 75, 25);
		formToolkit.adapt(clear, true, true);
		clear.setText("Clear");
		
		
		
		scrolledComposite = new ScrolledComposite(shlrdBaseCoach, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setBounds(10, 10, 964, 248);
		formToolkit.adapt(scrolledComposite);
		formToolkit.paintBordersFor(scrolledComposite);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		Group seqscroll = new Group(scrolledComposite, SWT.NONE);
		seqscroll.setText("Sequence Editor");
		formToolkit.adapt(seqscroll);
		formToolkit.paintBordersFor(seqscroll);

		seq1 = new Combo(seqscroll, SWT.NONE);
		seq1.setItems(new String[] {"None", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"});
		seq1.setBounds(10, 29, 120, 23);
		formToolkit.adapt(seq1);
		formToolkit.paintBordersFor(seq1);
		seq1.setText("Select a Letter");
		
		seq2 = new Combo(seqscroll, SWT.NONE);
		seq2.setBounds(10, 58, 120, 23);
		seq2.setItems(new String[] {"None", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"});
		formToolkit.adapt(seq2);
		formToolkit.paintBordersFor(seq2);
		seq2.setText("Select a Letter");
		
		seq3 = new Combo(seqscroll, SWT.NONE);
		seq3.setBounds(10, 87, 120, 23);
		seq3.setItems(new String[] {"None", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"});
		formToolkit.adapt(seq3);
		formToolkit.paintBordersFor(seq3);
		seq3.setText("Select a Letter");
		
		seq4 = new Combo(seqscroll, SWT.NONE);
		seq4.setItems(new String[] {"None", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"});
		seq4.setBounds(10, 116, 120, 23);
		formToolkit.adapt(seq4);
		formToolkit.paintBordersFor(seq4);
		seq4.setText("Select a Letter");
		
		seq5 = new Combo(seqscroll, SWT.NONE);
		seq5.setItems(new String[] {"None", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"});
		seq5.setBounds(10, 145, 120, 23);
		formToolkit.adapt(seq5);
		formToolkit.paintBordersFor(seq5);
		seq5.setText("Select a Letter");
		
		seq6 = new Combo(seqscroll, SWT.NONE);
		seq6.setItems(new String[] {"None", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"});
		seq6.setBounds(10, 174, 120, 23);
		formToolkit.adapt(seq6);
		formToolkit.paintBordersFor(seq6);
		seq6.setText("Select a Letter");
		
		seq7 = new Combo(seqscroll, SWT.NONE);
		seq7.setItems(new String[] {"None", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"});
		seq7.setBounds(10, 203, 120, 23);
		formToolkit.adapt(seq7);
		formToolkit.paintBordersFor(seq7);
		seq7.setText("Select a Letter");
		
		seq8 = new Combo(seqscroll, SWT.NONE);
		seq8.setItems(new String[] {"None", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"});
		seq8.setBounds(10, 232, 120, 23);
		formToolkit.adapt(seq8);
		formToolkit.paintBordersFor(seq8);
		seq8.setText("Select a Letter");
		
		seq9 = new Combo(seqscroll, SWT.NONE);
		seq9.setItems(new String[] {"None", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"});
		seq9.setBounds(10, 261, 120, 23);
		formToolkit.adapt(seq9);
		formToolkit.paintBordersFor(seq9);
		seq9.setText("Select a Letter");
		
		seq10 = new Combo(seqscroll, SWT.NONE);
		seq10.setItems(new String[] {"None", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"});
		seq10.setBounds(10, 290, 120, 23);
		formToolkit.adapt(seq10);
		formToolkit.paintBordersFor(seq10);
		seq10.setText("Select a Letter");
		
		seq11 = new Combo(seqscroll, SWT.NONE);
		seq11.setItems(new String[] {"None", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"});
		seq11.setBounds(10, 319, 120, 23);
		formToolkit.adapt(seq11);
		formToolkit.paintBordersFor(seq11);
		seq11.setText("Select a Letter");
		
		seq12 = new Combo(seqscroll, SWT.NONE);
		seq12.setItems(new String[] {"None", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"});
		seq12.setBounds(10, 348, 120, 23);
		formToolkit.adapt(seq12);
		formToolkit.paintBordersFor(seq12);
		seq12.setText("Select a Letter");
		
		seq13 = new Combo(seqscroll, SWT.NONE);
		seq13.setItems(new String[] {"None", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"});
		seq13.setBounds(10, 377, 120, 23);
		formToolkit.adapt(seq13);
		formToolkit.paintBordersFor(seq13);
		seq13.setText("Select a Letter");
		
		seq14 = new Combo(seqscroll, SWT.NONE);
		seq14.setItems(new String[] {"None", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"});
		seq14.setBounds(10, 406, 120, 23);
		formToolkit.adapt(seq14);
		formToolkit.paintBordersFor(seq14);
		seq14.setText("Select a Letter");
		
		seq15 = new Combo(seqscroll, SWT.NONE);
		seq15.setItems(new String[] {"None", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"});
		seq15.setBounds(10, 435, 120, 23);
		formToolkit.adapt(seq15);
		formToolkit.paintBordersFor(seq15);
		seq15.setText("Select a Letter");
		
		seq16 = new Combo(seqscroll, SWT.NONE);
		seq16.setItems(new String[] {"None", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"});
		seq16.setBounds(10, 464, 120, 23);
		formToolkit.adapt(seq16);
		formToolkit.paintBordersFor(seq16);
		seq16.setText("Select a Letter");
		
		seq17 = new Combo(seqscroll, SWT.NONE);
		seq17.setItems(new String[] {"None", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"});
		seq17.setBounds(10, 493, 120, 23);
		formToolkit.adapt(seq17);
		formToolkit.paintBordersFor(seq17);
		seq17.setText("Select a Letter");
		
		seq18 = new Combo(seqscroll, SWT.NONE);
		seq18.setItems(new String[] {"None", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"});
		seq18.setBounds(10, 522, 120, 23);
		formToolkit.adapt(seq18);
		formToolkit.paintBordersFor(seq18);
		seq18.setText("Select a Letter");
		
		seq19 = new Combo(seqscroll, SWT.NONE);
		seq19.setItems(new String[] {"None", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"});
		seq19.setBounds(10, 551, 120, 23);
		formToolkit.adapt(seq19);
		formToolkit.paintBordersFor(seq19);
		seq19.setText("Select a Letter");
		
		seq20 = new Combo(seqscroll, SWT.NONE);
		seq20.setItems(new String[] {"None", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"});
		seq20.setBounds(10, 580, 120, 23);
		formToolkit.adapt(seq20);
		formToolkit.paintBordersFor(seq20);
		seq20.setText("Select a Letter");
		
		seq21 = new Combo(seqscroll, SWT.NONE);
		seq21.setItems(new String[] {"None", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"});
		seq21.setBounds(10, 609, 120, 23);
		formToolkit.adapt(seq21);
		formToolkit.paintBordersFor(seq21);
		seq21.setText("Select a Letter");
		
		seq22 = new Combo(seqscroll, SWT.NONE);
		seq22.setItems(new String[] {"None", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"});
		seq22.setBounds(10, 638, 120, 23);
		formToolkit.adapt(seq22);
		formToolkit.paintBordersFor(seq22);
		seq22.setText("Select a Letter");
		
		seq23 = new Combo(seqscroll, SWT.NONE);
		seq23.setItems(new String[] {"None", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"});
		seq23.setBounds(10, 667, 120, 23);
		formToolkit.adapt(seq23);
		formToolkit.paintBordersFor(seq23);
		seq23.setText("Select a Letter");
		
		seq24 = new Combo(seqscroll, SWT.NONE);
		seq24.setItems(new String[] {"None", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"});
		seq24.setBounds(10, 696, 120, 23);
		formToolkit.adapt(seq24);
		formToolkit.paintBordersFor(seq24);
		seq24.setText("Select a Letter");
		
		seq25 = new Combo(seqscroll, SWT.NONE);
		seq25.setItems(new String[] {"None", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"});
		seq25.setBounds(10, 725, 120, 23);
		formToolkit.adapt(seq25);
		formToolkit.paintBordersFor(seq25);
		seq25.setText("Select a Letter");
				
		seq26 = new Combo(seqscroll, SWT.NONE);
		seq26.setItems(new String[] {"None", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"});
		seq26.setBounds(10, 754, 120, 23);
		formToolkit.adapt(seq26);
		formToolkit.paintBordersFor(seq26);
		seq26.setText("Select a Letter");
		
		desc1 = new Text(seqscroll, SWT.BORDER);
		desc1.setBounds(136, 29, 765, 21);
		formToolkit.adapt(desc1, true, true);
		
		desc2 = new Text(seqscroll, SWT.BORDER);
		desc2.setBounds(136, 58, 765, 21);
		formToolkit.adapt(desc2, true, true);
		
		desc3 = new Text(seqscroll, SWT.BORDER);
		desc3.setBounds(136, 87, 765, 21);
		formToolkit.adapt(desc3, true, true);
		
		desc4 = new Text(seqscroll, SWT.BORDER);
		desc4.setBounds(136, 114, 765, 21);
		formToolkit.adapt(desc4, true, true);
		
		desc5 = new Text(seqscroll, SWT.BORDER);
		desc5.setBounds(136, 145, 765, 21);
		formToolkit.adapt(desc5, true, true);
		
		desc6 = new Text(seqscroll, SWT.BORDER);
		desc6.setBounds(136, 172, 765, 21);
		formToolkit.adapt(desc6, true, true);
		
		desc7 = new Text(seqscroll, SWT.BORDER);
		desc7.setBounds(136, 203, 765, 21);
		formToolkit.adapt(desc7, true, true);
		
		desc8 = new Text(seqscroll, SWT.BORDER);
		desc8.setBounds(136, 234, 765, 21);
		formToolkit.adapt(desc8, true, true);
		
		desc9 = new Text(seqscroll, SWT.BORDER);
		desc9.setBounds(136, 261, 765, 21);
		formToolkit.adapt(desc9, true, true);
		
		desc10 = new Text(seqscroll, SWT.BORDER);
		desc10.setBounds(136, 290, 765, 21);
		formToolkit.adapt(desc10, true, true);
		
		desc11 = new Text(seqscroll, SWT.BORDER);
		desc11.setBounds(136, 319, 765, 21);
		formToolkit.adapt(desc11, true, true);
		
		desc12 = new Text(seqscroll, SWT.BORDER);
		desc12.setBounds(136, 348, 765, 21);
		formToolkit.adapt(desc12, true, true);
		
		desc13 = new Text(seqscroll, SWT.BORDER);
		desc13.setBounds(136, 377, 765, 21);
		formToolkit.adapt(desc13, true, true);
		
		desc14 = new Text(seqscroll, SWT.BORDER);
		desc14.setBounds(136, 404, 765, 21);
		formToolkit.adapt(desc14, true, true);
		
		desc15 = new Text(seqscroll, SWT.BORDER);
		desc15.setBounds(136, 435, 765, 21);
		formToolkit.adapt(desc15, true, true);
		
		desc16 = new Text(seqscroll, SWT.BORDER);
		desc16.setBounds(136, 464, 765, 21);
		formToolkit.adapt(desc16, true, true);

		
		desc17 = new Text(seqscroll, SWT.BORDER);
		desc17.setBounds(136, 493, 765, 21);
		formToolkit.adapt(desc17, true, true);
		
		desc18 = new Text(seqscroll, SWT.BORDER);
		desc18.setBounds(136, 522, 765, 21);
		formToolkit.adapt(desc18, true, true);
		
		desc19 = new Text(seqscroll, SWT.BORDER);
		desc19.setBounds(136, 551, 765, 21);
		formToolkit.adapt(desc19, true, true);
		
		desc20 = new Text(seqscroll, SWT.BORDER);
		desc20.setBounds(136, 580, 765, 21);
		formToolkit.adapt(desc20, true, true);
		
		desc21 = new Text(seqscroll, SWT.BORDER);
		desc21.setBounds(136, 609, 765, 21);
		formToolkit.adapt(desc21, true, true);
		
		desc22 = new Text(seqscroll, SWT.BORDER);
		desc22.setBounds(136, 638, 765, 21);
		formToolkit.adapt(desc22, true, true);
		
		desc23 = new Text(seqscroll, SWT.BORDER);
		desc23.setBounds(136, 667, 765, 21);
		formToolkit.adapt(desc23, true, true);
		
		desc24 = new Text(seqscroll, SWT.BORDER);
		desc24.setBounds(136, 694, 765, 21);
		formToolkit.adapt(desc24, true, true);
		
		desc25 = new Text(seqscroll, SWT.BORDER);
		desc25.setBounds(136, 725, 765, 21);
		formToolkit.adapt(desc25, true, true);
		
		desc26 = new Text(seqscroll, SWT.BORDER);
		desc26.setBounds(136, 754, 765, 21);
		formToolkit.adapt(desc26, true, true);
		scrolledComposite.setContent(seqscroll);
		scrolledComposite.setMinSize(seqscroll.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		seq1.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (checkDupe()==1)
				{seq1.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));} else {seq1.setBackground(null);}
			}
		});
		seq2.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (checkDupe()==1)
				{seq2.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));} else {seq2.setBackground(null);}
			}
		});
		seq3.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (checkDupe()==1)
				{seq3.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));} else {seq3.setBackground(null);}
			}
		});
		seq4.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (checkDupe()==1)
				{seq4.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));} else {seq4.setBackground(null);}
			}
		});
		seq5.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (checkDupe()==1)
				{seq5.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));} else {seq5.setBackground(null);}
			}
		});
		seq6.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (checkDupe()==1)
				{seq6.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));} else {seq6.setBackground(null);}
			}
		});
		seq7.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (checkDupe()==1)
				{seq7.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));} else {seq7.setBackground(null);}
			}
		});
		seq8.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (checkDupe()==1)
				{seq8.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));} else {seq8.setBackground(null);}
			}
		});
		seq9.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (checkDupe()==1)
				{seq9.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));} else {seq9.setBackground(null);}
			}
		});
		seq10.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (checkDupe()==1)
				{seq10.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));} else {seq10.setBackground(null);}
			}
		});
		seq11.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (checkDupe()==1)
				{seq11.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));} else {seq11.setBackground(null);}
			}
		});
		seq12.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (checkDupe()==1)
				{seq12.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));} else {seq12.setBackground(null);}
			}
		});
		seq13.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (checkDupe()==1)
				{seq13.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));} else {seq13.setBackground(null);}
			}
		});
		seq14.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (checkDupe()==1)
				{seq14.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));} else {seq14.setBackground(null);}
			}
		});
		seq15.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (checkDupe()==1)
				{seq15.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));} else {seq15.setBackground(null);}
			}
		});
		seq16.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (checkDupe()==1)
				{seq16.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));} else {seq16.setBackground(null);}
			}
		});
		seq17.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (checkDupe()==1)
				{seq17.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));} else {seq17.setBackground(null);}
			}
		});
		seq18.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (checkDupe()==1)
				{seq18.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));} else {seq18.setBackground(null);}
			}
		});
		seq19.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (checkDupe()==1)
				{seq19.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));} else {seq19.setBackground(null);}
			}
		});
		seq20.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (checkDupe()==1)
				{seq20.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));} else {seq20.setBackground(null);}
			}
		});
		seq21.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (checkDupe()==1)
				{seq21.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));} else {seq21.setBackground(null);}
			}
		});
		seq22.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (checkDupe()==1)
				{seq22.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));} else {seq22.setBackground(null);}
			}
		});
		seq23.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (checkDupe()==1)
				{seq23.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));} else {seq23.setBackground(null);}
			}
		});
		seq24.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (checkDupe()==1)
				{seq24.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));} else {seq24.setBackground(null);}
			}
		});
		seq25.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (checkDupe()==1)
				{seq25.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));} else {seq25.setBackground(null);}
			}
		});
		seq26.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (checkDupe()==1)
				{seq26.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));} else {seq26.setBackground(null);}
			}
		});


	
		
	}

	protected int checkDupe() {
		int match = 0;
			for(int i= 0; i<varIndex.length; i++)
			{
				switch (i)
				{
				case 1: varIndex[i] = seq1.getSelectionIndex(); break;
				case 2: varIndex[i] = seq2.getSelectionIndex(); break;
				case 3: varIndex[i] = seq3.getSelectionIndex(); break;
				case 4: varIndex[i] = seq4.getSelectionIndex(); break;
				case 5: varIndex[i] = seq5.getSelectionIndex(); break;
				case 6: varIndex[i] = seq6.getSelectionIndex(); break;
				case 7: varIndex[i] = seq7.getSelectionIndex(); break;
				case 8: varIndex[i] = seq8.getSelectionIndex(); break;
				case 9: varIndex[i] = seq9.getSelectionIndex(); break;
				case 10: varIndex[i] = seq10.getSelectionIndex(); break;
				case 11: varIndex[i] = seq11.getSelectionIndex(); break;
				case 12: varIndex[i] = seq12.getSelectionIndex(); break;
				case 13: varIndex[i] = seq13.getSelectionIndex(); break;
				case 14: varIndex[i] = seq14.getSelectionIndex(); break;
				case 15: varIndex[i] = seq15.getSelectionIndex(); break;
				case 16: varIndex[i] = seq16.getSelectionIndex(); break;
				case 17: varIndex[i] = seq17.getSelectionIndex(); break;
				case 18: varIndex[i] = seq18.getSelectionIndex(); break;
				case 19: varIndex[i] = seq19.getSelectionIndex(); break;
				case 20: varIndex[i] = seq20.getSelectionIndex(); break;
				case 21: varIndex[i] = seq21.getSelectionIndex(); break;
				case 22: varIndex[i] = seq22.getSelectionIndex(); break;
				case 23: varIndex[i] = seq23.getSelectionIndex(); break;
				case 24: varIndex[i] = seq24.getSelectionIndex(); break;
				case 25: varIndex[i] = seq25.getSelectionIndex(); break;
				case 26: varIndex[i] = seq26.getSelectionIndex(); break;
				}
				for(int j=0; j<varIndex.length; j++)
				{
					if ((varIndex[i] == varIndex[j]) && (varIndex[i] > 0) && (i != j))
					{
						match = 1;
						text.setText(Integer.toString(i) + " matches " + Integer.toString(j) + " because " + Integer.toString(varIndex[i]) + "=" + Integer.toString(varIndex[j]));
					} else {
						
					}
				}
				
			}
			return match;
		}
		
}
