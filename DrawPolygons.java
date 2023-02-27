/* This is now all we (can) use from the sub-package */
import edu.chalmers_gu_cse.oopd.exercises.controller.PolygonClicker;
import edu.chalmers_gu_cse.oopd.exercises.polygonModel.PolygonModel;
import edu.chalmers_gu_cse.oopd.exercises.polygonModel.polygon.PolygonFactory;
import edu.chalmers_gu_cse.oopd.exercises.view2d.PolygonViewer;

import javax.swing.*;

/* By commenting out the imports above, and instead importing the edu.chalmers_gu_cse.oopd.exercises.polygonModel.adapter package,
 * we effectively switch to using the DIT952.edu.chalmers_gu_cse.oopd.exercises.polygonModel.shapes package.
 */
// import DIT952.edu.chalmers_gu_cse.oopd.exercises.polygonModel.adapter.*;

public class DrawPolygons {

    public static void main(String[] args) {
        PolygonModel polygons = initModel();
        PolygonViewer view = initViewForModel(polygons);
        initUIForView(view);
        PolygonClicker controller = new PolygonClicker(polygons, view);

        // TODO: Step 2: Create a Macro that uses an ExampleTransform,
        //  and pass this to the animation function.
        polygons.animate();
        // TODO: Step 3: Instead of using ExampleTransform, write a lambda
        //  expression that does the same thing.

    }//main
    private static void initUIForView(PolygonViewer view) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setBounds(30, 30, 300, 300);
        frame.add(view);
    }
    public static PolygonModel initModel(){
        PolygonModel polygons = new PolygonModel();

        polygons.addPolygon(PolygonFactory.createSquare(50,50));
        polygons.addPolygon(PolygonFactory.createTriangle(100,100));
        polygons.addPolygon(PolygonFactory.createRectangle(50,150));

        return polygons;
    }//initModel

    private static PolygonViewer initViewForModel(PolygonModel polygonModel) {
        PolygonViewer view = new PolygonViewer();
        view.addModel(polygonModel);
        polygonModel.addListener(view);
        return view;
    }//initViewForModel

}//DrawPolygons