import React from 'react'
import { Link } from 'react-router'

export default class AsideBar extends React.Component {
    constructor(props) {
        super(props)
    }

    render() {
        let listItems = []

        if (this.props.hasChangeTree && this.props.hasChangeTree === true) {
            listItems.push(
                <button key="org" onClick={this.props.toggleOrgPanel} className="btn btn-block btn-danger">
                    <i className="fa fa-sitemap fa-lg" aria-hidden="true"></i>
                </button>
            )
        }

        $.each(SCHOOLPAL_CONFIG.commandRules, (k, v) => {
            listItems.push(
                <Link key={v.id} to={SCHOOLPAL_CONFIG.ROOTPATH + v.PATH} className="btn btn-block btn-link">
                    <i className={'fa ' + v.ICON + ' fa-lg'} aria-hidden="true"></i>
                </Link>
            )
        })

        return (
            <div className="aside-bar bg-faded">
                {listItems}
            </div>
        )
    }
}