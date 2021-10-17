package usth.facebook;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WatchFace#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WatchFace extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    VideoView videoView;
    VideoView videoView2;
    VideoView videoView3;
    VideoView videoView4;

    public WatchFace() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static WatchFace newInstance() {
        WatchFace fragment = new WatchFace();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_watch_face, container, false);
        /** Face Watch 1 */
        videoView = (VideoView) view.findViewById(R.id.video_view);
        Uri video = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + R.raw.video1);
        videoView.setVideoURI(video);

        MediaController mediaController = new MediaController(getActivity());
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        /** Face Watch 2 */
        videoView2 = (VideoView) view.findViewById(R.id.video_view2);
        Uri video2 = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + R.raw.video2);
        videoView2.setVideoURI(video2);

        MediaController mediaController2 = new MediaController(getActivity());
        videoView2.setMediaController(mediaController2);
        mediaController2.setAnchorView(videoView2);
        /** Face Watch 3 */
        videoView3 = (VideoView) view.findViewById(R.id.video_view3);
        Uri video3 = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + R.raw.video3);
        videoView3.setVideoURI(video3);

        MediaController mediaController3 = new MediaController(getActivity());
        videoView3.setMediaController(mediaController3);
        mediaController2.setAnchorView(videoView3);
        /** Face Watch 4 */
        videoView4 = (VideoView) view.findViewById(R.id.video_view4);
        Uri video4 = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + R.raw.video4);
        videoView4.setVideoURI(video4);

        MediaController mediaController4 = new MediaController(getActivity());
        videoView4.setMediaController(mediaController4);
        mediaController4.setAnchorView(videoView4);

        // Inflate the layout for this fragment

        return view;
    }
}