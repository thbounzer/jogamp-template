package thebounzer.org.ogltemplate;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.opengl.*;
import javax.media.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.*;
/**
 *
 * @author thbounzer
 */
public class OglMain implements GLEventListener{
    public static void main(String[] args) {
            GLProfile glp = GLProfile.getDefault();
            GLCapabilities caps = new GLCapabilities(glp);
            
            // Uhm, don't know what this does. Include it or antialiasing will not work!
            caps.setSampleBuffers(true);
            caps.setNumSamples(3);
            
            GLCanvas canvas = new GLCanvas(caps);
            Frame frame = new Frame("Yourtitle");
            frame.setSize(600, 600);
            frame.add(canvas);
            frame.setVisible(true);
            int fps = 5;

            frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });

            canvas.addGLEventListener(new OglMain());
            FPSAnimator animator = new FPSAnimator(canvas,fps);  
            animator.start();

        }    

        @Override
        public void init(GLAutoDrawable drawable) {
            GL2 gl = drawable.getGL().getGL2();
            gl.glEnable(GL2.GL_LINE_SMOOTH);
            gl.glEnable(GL2.GL_BLEND);
            gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
            gl.glHint(GL2.GL_LINE_SMOOTH_HINT, GL2.GL_NICEST);
            gl.glShadeModel(GL2.GL_SMOOTH);
        }

        @Override
        public void dispose(GLAutoDrawable drawable) {

        }

        @Override
        public void display(GLAutoDrawable drawable) {
            render(drawable);
        }

        @Override
        public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {

        }


        private void render(GLAutoDrawable drawable) {
            GL2 gl = drawable.getGL().getGL2();

            gl.glClear(GL.GL_COLOR_BUFFER_BIT);

            gl.glBegin(GL.GL_TRIANGLES);

            gl.glEnd();

        } 
}
