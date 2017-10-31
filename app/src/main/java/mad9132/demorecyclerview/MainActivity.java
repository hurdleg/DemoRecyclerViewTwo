package mad9132.demorecyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;

import mad9132.demorecyclerview.model.CoursePOJO;

/**
 * Demonstrate Android's RecyclerView - Continued.
 *
 * Same class as DemoRecyclerView, with these exceptions:
 *
 *  a) Represent the course data as a JSON String.
 *  b) use Gson to parse the JSON String into an array of CoursePOJO objects.
 *  c) use Arrays.asList() to convert to an ArrayList<CoursePOJO>
 *
 * @author Gerald.Hurdle@AlgonquinCollege.com
 *
 */
public class MainActivity extends Activity {

    private final static String COURSE_DATA_JSON_STRING = "[{" +
            "\"courseId\": 1," +
            "\"code\": \"MAD9014\"," +
            "\"name\": \"Cross-Platform Application Development I\"," +
            "\"description\": \"Let's learn JavaScript!\"," +
            "\"level\": 1" +
            "}, {" +
            "\"courseId\": 2," +
            "\"code\": \"MAD9020\"," +
            "\"name\": \"User Interface Design\"," +
            "\"description\": \"Let's design with the User in-mind!\"," +
            "\"level\": 2\n" +
            "}, {" +
            "\"courseId\": 3," +
            "\"code\": \"MAD9132\",\n" +
            "\"name\": \"Android Application Development\",\n" +
            "\"description\": \"Let's write native Android apps with Java!\"," +
            "\"level\": 3" +
            "}, {" +
            "\"courseId\": 4," +
            "\"code\": \"MA9145\"," +
            "\"name\": \"Applied Project\"," +
            "\"description\": \"It's Go time!\"," +
            "\"level\": 4" +
            "}]";

    private CourseAdapter mAdapter;
    private RecyclerView  mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // collection of course objects; use an ArrayList, with each element of type CoursePOJO
        // 1. Convert the JSON String to an array of CoursePOJO[]
        // 2. Convert the array to an ArrayList<CoursePOJO>
        Gson gson = new Gson();
        ArrayList<CoursePOJO> courseArrayList =
                new ArrayList<>(Arrays.asList(gson.fromJson(COURSE_DATA_JSON_STRING, CoursePOJO[].class)));

        // reference the RecyclerView
        mRecyclerView = (RecyclerView) findViewById(R.id.rvCourses);

        // instantiate the Adapter
        // pass in this Activity's Context, and the collection of CoursePOJO objects
        mAdapter = new CourseAdapter(this, courseArrayList);

        // replace the RecyclerView's adapter with ours
        mRecyclerView.setAdapter(mAdapter);
    }
}
