var path = require('path');
var webpack = require('webpack');

var ROOT_PATH = path.resolve(__dirname);
var DEV_PATH = path.resolve(ROOT_PATH, 'src');
var BUILD_PATH = path.resolve(ROOT_PATH, 'static/dist');

module.exports = {
    entry: path.resolve(DEV_PATH, 'app.jsx'),
    output: {
        path: BUILD_PATH,
        filename: 'bundle.js'
    },
    module: {
        loaders: [{
            test: /\.jsx?$/,
            loader: 'babel',
            include: DEV_PATH,
            query: {
                presets: ['es2015', 'react']
            }
        }, {
            test: /\.less$/,
            loader: 'style-loader!css-loader!less-loader'
        }, {
            test: /\.(png|jpg)$/,
            loader: 'url?limit=8192'
        }, {
            test: /\.(gif|jpg|png|woff|svg|eot|ttf)\??.*$/,
            loader: 'url'
        }]
    },
    resolve: {
        extensions: ['', '.js', '.jsx']
    }
}
