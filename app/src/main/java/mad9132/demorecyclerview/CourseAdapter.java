package mad9132.demorecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import mad9132.demorecyclerview.model.CoursePOJO;

/**
 * CourseAdapter. No changes from DemoRecyclerView.
 *
 * @author Gerald.Hurdle@AlgonquinCollege.com
 *
 */
public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {

    private Context          mContext;
    private List<CoursePOJO> mCourses;

    public CourseAdapter(Context context, List<CoursePOJO> courses) {
        this.mContext = context;
        this.mCourses = courses;
    }

    @Override
    public CourseAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View planetView = inflater.inflate(R.layout.course_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(planetView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CourseAdapter.ViewHolder holder, final int position) {
        final CoursePOJO aCourse = mCourses.get(position);

        holder.tvCode.setText(aCourse.getCode());
        holder.tvName.setText(aCourse.getName());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Selected Course: " + aCourse.getCode(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCourses.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public View     mView;
        public TextView tvCode;
        public TextView tvName;

        public ViewHolder(View courseView) {
            super(courseView);

            mView = courseView;

            tvCode = (TextView) courseView.findViewById(R.id.courseCodeText);
            tvName = (TextView) courseView.findViewById(R.id.courseNameText);
        }
    }
}
