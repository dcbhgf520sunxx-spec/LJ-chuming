import { ref as n } from "vue";
function L({ detailMethod: v, passedMethod: d, returnedMethod: y, pendingListMethod: p, detailInitCallBack: w, closeDlg: r }) {
  const o = n(), t = n(false), a = n(false), l = n(0), u = n(false), c = n([]), h = n();
  function C(e) {
    s(), v(e);
  }
  function s() {
    a.value = false, t.value = false, typeof initCallBack == "function" && w();
  }
  async function g() {
    c.value = await p();
  }
  async function m() {
    try {
      t.value = true, await d(), i();
    } catch (e) {
      console.log("通过提交", e);
    } finally {
      t.value = false;
    }
  }
  async function R() {
    try {
      a.value = true, await y(), i();
    } catch (e) {
      console.log("退回", e);
    } finally {
      a.value = false;
    }
  }
  function i() {
    try {
      ++l.value, u.value && o.value ? o.value.removeCurrent() : f();
    } catch (e) {
      console.log("审核提交后", e), f();
    }
  }
  function f() {
    typeof r == "function" && r();
  }
  return { reviewNext: u, currentRecordId: h, pendingReviewIdList: c, operateRecordNumber: l, returnedLoading: a, passedLoading: t, reviewConvenientRef: o, reviewInit: g, detailInit: s, passed: m, returned: R, handleAfterSubmit: i, handleConvenientChange: C };
}
export {
  L as u
};
