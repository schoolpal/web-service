function insertTree(rootData, data) {
    if (rootData.cId === data.cParentId) {
        if (!rootData.children) {
            rootData.children = [];
        };

        rootData.children.push(data);
    } else {
        if (rootData.children && rootData.children.length) {
            $.each(rootData.children, function (i, item) {
                insertTree(item, data);
            })
        };
    }
}

export function conversionOrg(original) {
    const data = original.map((item) => { return $.extend({}, item) });
    let tree = [];
    let rootLevel = [];

    if (data.length) {
        $.each(data, function (i, item) {
            rootLevel.push(item.level);

            if (item.cId === item.cParentId) {
                tree.push(item)
            } else {
                const rootIndex = _.findIndex(tree, { cId: item.cRootId });

                insertTree(tree[rootIndex], item);
            }
        })
    }

    rootLevel = _.uniq(rootLevel);

    return {
        original,
        tree,
        rootLevel: rootLevel.length ? Math.min(...rootLevel) : null
    };
}

function insertFunc(rootData, data) {
    if (rootData.cId === data.cParentId) {
        if (data.cCommandTypeId) {
            if (!rootData.action) {
                rootData.action = [];
            };

            rootData.action.push(data);
        } else {
            if (!rootData.children) {
                rootData.children = [];
            };

            rootData.children.push(data);
        }
    } else {
        if (rootData.children && rootData.children.length) {
            rootData.children.map((item) => {
                insertFunc(item, data);
            })
        };
    }
}

export function conversionFunc(original) {
    const data = original.map((item) => { return $.extend({}, item) });
    let tree = [];

    if (data.length) {
        data.map((item) => {
            if (item.cId === item.cRootId) {
                tree.push(item);
            } else {
                const rootIndex = _.findIndex(tree, { cId: item.cRootId });

                insertFunc(tree[rootIndex], item);
            };
        })
    }

    return tree;
}