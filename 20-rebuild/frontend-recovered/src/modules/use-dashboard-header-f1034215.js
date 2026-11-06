import { bX as e } from "../shared/runtime.js";
import { watch as L } from "vue";
function E({ colorCardTitles: n = ["未入库", "部分入库", "全部入库"], emit: i, crud: r, fetchSummaryInfo: u }) {
  const R = [{ title: n[0], color: e.UNSTART.COLOR, value: e.UNSTART.V }, { title: n[1], color: e.PROCESS.COLOR, value: e.PROCESS.V }, { title: n[2], color: e.COMPLETE.COLOR, value: e.COMPLETE.V }];
  L([() => r.query.monomerId, () => r.query.factoryId], () => {
    typeof u == "function" && u();
  }, { immediate: true });
  function s(t, { quantity: o = "inboundQuantity", compare: O = "compareQuantity" }) {
    return t[o] === 0 && !t.isProcess ? e.UNSTART.COLOR : t[o] === t[O] ? e.COMPLETE.COLOR : t.isProcess || t[o] > 0 && t[o] < t[O] ? e.PROCESS.COLOR : e.ABNORMAL.COLOR;
  }
  function C(t, { field: o = "type" }) {
    const O = e.VK[t[o]];
    return O ? e[O].COLOR : e.ABNORMAL.COLOR;
  }
  function a(t, { field: o = "type" }) {
    const O = e.VK[t[o]];
    return O ? e[O].T : e.ABNORMAL.T;
  }
  function f() {
    r.page.hasNextPage && i("load");
  }
  return { colors: R, boxZoomOut: f, getColor: s, getColorByValue: C, getTagByValue: a };
}
export {
  E as u
};
