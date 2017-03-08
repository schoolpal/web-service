import React from 'react';

export default class OrgTree extends React.Component {
    constructor(props) {
        super(props)

        this.renderTree = this.renderTree.bind(this);
        this.renderTreeItem = this.renderTreeItem.bind(this);
        this.handleSelect = this.handleSelect.bind(this);
        this.handleNode = this.handleNode.bind(this);
    }

    renderTree(data) {
        let tree = [];

        data.map((item) => {
            let children = [];            
            
            if (item.children && item.children.length) {
                let children = [];

                children.push(this.renderTree(item.children));
                tree.push(
                    <li key={item.cId}>
                        {this.renderTreeItem(item)}
                        <ul>{children}</ul>
                    </li>
                );
            } else {
                tree.push(
                    <li key={item.cId}>{this.renderTreeItem(item)}</li>
                )
            }
        })

        return tree;
    }

    renderTreeItem(data) {
        const nodeClass = 'tree-node ' + ((data.children && data.children.length) ? '' : 'not-child');
        const nodeSelectClass = 'select ' + (this.props.defaults && this.props.defaults.toString() === data.cId ? 'selected' : '');

        return (
            <div className="hd">
                <i onClick={this.handleNode} data-node className={nodeClass}></i>
                <p onClick={this.handleSelect} data-o={data.cId} className={nodeSelectClass}><span>{data.cName}</span></p>
            </div>
        )
    }

    handleSelect(event) {
        const elem = $(event.target).data('o') ? $(event.target) : $(event.target).parent();

        if (elem.hasClass('selected')) {
            this.props.selected(null);
        } else {
            this.props.selected({
                id: elem.data('o'),
                name: elem.children('span').text()
            })
        }
    }

    handleNode(event) {
        if ($(event.target).hasClass('not-child')) {
            return;
        };

        if ($(event.target).hasClass('closed')) {
            $(event.target)
                .removeClass('closed')
                .closest('li')
                .children('ul')
                .show();
        } else {
            $(event.target)
                .closest('li')
                .find('[data-node]')
                .addClass('closed')
                .end()
                .closest('li')
                .find('ul')
                .hide();
        };
    }

    render() {
        return (
            <div className="tree">
                <ul>
                    {this.renderTree(this.props.data)}
                </ul>
            </div>
        )
    }
}