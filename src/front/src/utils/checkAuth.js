export default function checkAuth(nextState, replace) {
    let hasMatch = 0;

    if (SCHOOLPAL_CONFIG.authPath) {
        SCHOOLPAL_CONFIG.authPath.map((rule) => {
            const temp = nextState.location.pathname.replace(SCHOOLPAL_CONFIG.ROOTPATH, '');
            console.log(temp);
            if (rule.test(temp) === true) {
                hasMatch++
            }
        })

        if (!hasMatch) {
            replace({
                pathname: SCHOOLPAL_CONFIG.ROOTPATH + 'error'
            })
        }
    };
}