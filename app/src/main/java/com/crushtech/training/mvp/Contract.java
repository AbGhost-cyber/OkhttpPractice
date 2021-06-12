package com.crushtech.training.mvp;

public interface Contract {
    interface View {
        void showProgress();

        void hideProgress();

        void setData(String string);
    }

    interface Model {
        void fetchNextData(onFinishedListener onFinishedListener);

        interface onFinishedListener {
            void onFinished(String string);
        }
    }

    interface Presenter {
        void onButtonClick();

        void onDestroy();
    }

    class Todo {
        int userId, id;
        boolean completed;
        String title;

        public Todo(int userId, int id, boolean completed, String title) {
            this.userId = userId;
            this.id = id;
            this.completed = completed;
            this.title = title;
        }
    }
}
