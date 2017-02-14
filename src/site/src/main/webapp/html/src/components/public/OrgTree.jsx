import React from 'react';

function TreeItems(data) {
    const nodeClass = 'tree-node closed ' + ((data.children && data.children.length) ? '' : 'not-child');

    return (
        <div className="hd">
            <i data-node className={nodeClass}></i>
            <p data-select={data.id} className="tree-select d-inline-block"><span>{data.name}</span></p>
        </div>
    )
}

export default class OrgTree extends React.Component {
    constructor(props) {
        super(props)
        this.renderTree = this.renderTree.bind(this);
    }

    componentDidMount() {
        const elem = this;

        $(this.treeDom)
            .on('click', '[data-select]', function () {
                if ($(this).hasClass('selected') === false) {
                    $(elem.treeDom)
                        .find('[data-select]')
                        .removeClass('selected');
                };

                $(this).toggleClass('selected');
            })
            .on('click', '[data-node]', function () {
                if ($(this).hasClass('not-child')) {
                    return;
                };

                if ($(this).hasClass('closed')) {
                    $(this)
                        .removeClass('closed')
                        .closest('li')
                        .children('ul')
                        .show();
                } else {
                    $(this)
                        .closest('li')
                        .find('[data-node]')
                        .addClass('closed')
                        .end()
                        .closest('li')
                        .find('ul')
                        .hide();
                };
            })
    }

    renderTree(data) {
        let tree = [];

        if (data.children && data.children.length) {
            let children = [];

            data.children.forEach((item) => {
                children.push(this.renderTree(item));
            });

            tree.push(
                <li key={data.id}>
                    {TreeItems(data)}
                    <ul>{children}</ul>
                </li>
            );

        } else {
            tree.push(
                <li key={data.id}>{TreeItems(data)}</li>
            )
        };

        return tree;
    }

    render() {
        if (this.props.panel) {
            return (
                <div id="orgTreePanel" tabindex="-1" role="dialog" aria-hidden="true" className="modal fade">
                    <div className="modal-dialog" role="document">
                        <div className="modal-content">
                            <div className="modal-header">
                                <p className="modal-title">选择父级组织</p>
                                <button type="button" className="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div className="modal-body">
                                <div ref={(dom) => { this.treeDom = dom }} className="tree">
                                    <ul>
                                        {this.renderTree(this.props.data)}
                                    </ul>
                                </div>
                            </div>
                            <div className="modal-footer">
                                <button type="button" className="btn btn-primary">确定</button>
                                <button type="button" className="btn btn-secondary" data-dismiss="modal">取消</button>
                            </div>
                        </div>
                    </div>
                </div>
            )
        } else {
            return (
                <div className="tree">
                    <ul>
                        {this.renderTree(this.props.data)}
                    </ul>
                </div>
            )
        };
    }
}