export default function checkAuth(nextState, replace) {
    const temp = nextState.location.pathname.replace(SCHOOLPAL_CONFIG.ROOTPATH, '');
    let hasMatch = false;

    console.log('======== check auth ========')

    if (SCHOOLPAL_CONFIG.accessRules) {
        for (let i = 0; i < SCHOOLPAL_CONFIG.accessRules.length; i++) {
            if (SCHOOLPAL_CONFIG.accessRules[i].test(temp) === true) {
                hasMatch = true;
                break;
            }
        }

        if (hasMatch === false) {
            replace({
                pathname: SCHOOLPAL_CONFIG.ROOTPATH + 'error'
            })
        }
    }
}