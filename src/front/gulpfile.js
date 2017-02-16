var gulp = require('gulp');
var clean = require('gulp-clean');
var webpack = require('webpack');
var gulpWebpack = require('gulp-webpack');
var webpackConfig = require('./webpack.config');

var DEV_PATH = './html';
var BUILD_PATH = '../site/src/main/webapp/html';
var LIB_PATH = './lib/**/*';
var MOVE_DEV_PATH = './html/**/*';
var CLEAN_PATH = [];

CLEAN_PATH.push(DEV_PATH);
CLEAN_PATH.push(BUILD_PATH);

gulp.task('clean', function () {
    return gulp.src(CLEAN_PATH)
        .pipe(clean({ force: true }));
});

gulp.task('build-js', ['clean'], function () {
    return gulp.src('./src/app.jsx')
        .pipe(gulpWebpack(webpackConfig, webpack))
        .pipe(gulp.dest('html/dist/'));
});

gulp.task('move-lib', ['build-js'], function () {
    return gulp.src(LIB_PATH)
        .pipe(gulp.dest('html/lib'))
});

gulp.task('move-dev', ['move-lib'], function () {
    return gulp.src(MOVE_DEV_PATH)
        .pipe(gulp.dest(BUILD_PATH))
});

gulp.task('default', ['clean', 'build-js', 'move-lib', 'move-dev'], function () {
    console.log('=======================================');
    console.log('front-end build done !');
    console.log('=======================================');
});



