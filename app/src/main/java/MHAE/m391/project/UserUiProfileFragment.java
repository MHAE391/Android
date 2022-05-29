package MHAE.m391.project;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import MHAE.m391.project.DataBase.DataBase;

import MHAE.m391.project.DataBase.User;
import MHAE.m391.project.login;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UserUiProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserUiProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public UserUiProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UserUiProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UserUiProfileFragment newInstance(String param1, String param2) {
        UserUiProfileFragment fragment = new UserUiProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
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
        View view =inflater.inflate(R.layout.fragment_user_ui_profile, container, false);
        DataBase x=new DataBase(getActivity());
        User y=x.GetProfile();
         if(y!=null){
          TextView Name= view.findViewById(R.id.ProfileFullName);
        TextView Email= view.findViewById(R.id.ProfileEmail);
        TextView Phone= view.findViewById(R.id.ProfilePhone);
        TextView Age= view.findViewById(R.id.ProfileAge);
        Name.setText("Name : "+y.getName().toString());
        Email.setText("Email : " +y.getEmail().toString());
        Phone.setText("Phone : "+y.getPhone().toString());
        Age.setText("Age : "+y.getAge()+"");
       }
      view.findViewById(R.id.ChangePassword).setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              startActivity(new Intent(getActivity(),ChangePassword.class));
          }
      });
        return view;
    }

}