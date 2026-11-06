import { ref as h } from "vue";
import { watch as P } from "vue";
import { computed as y } from "vue";
import s from "moment";
import { resolveComponent as x } from "vue";
import { resolveDirective as F } from "vue";
import { openBlock as C } from "vue";
import { createBlock as T } from "vue";
import { withCtx as o } from "vue";
import { createVNode as n } from "vue";
import { createElementVNode as i } from "vue";
import { withDirectives as m } from "vue";
import { createTextVNode as M } from "vue";
import { unref as e } from "vue";
import { isRef as L } from "vue";
import { ElTag as $ } from "element-plus";
import { ElTableColumn as J } from "element-plus";
import { ElPagination as U } from "element-plus";
import { vLoading as Y } from "element-plus";
import { p as G } from "../../../../../../modules/main-material-track-74a129d5.js";
import { u as K, J as Q, o as W, a3 as V } from "../../../../../../shared/runtime.js";
import { _ as X } from "../../../../../../modules/index-3b2628f3.js";
import { p as Z } from "../../../../../../modules/mes-ee117a22.js";
import { _ as ee } from "../../../../../../modules/index-c83b228b.js";
import "../../../../../../modules/index-490fd9d7.js";
import "../../../../../../modules/index-897a9ea4.js";
const me = { __name: "production-record-detail", props: { visible: { type: Boolean, default: false }, projectId: { type: Number }, month: { type: String } }, emits: ["update:visible"], setup(z, { emit: R }) {
  const v = h(), k = R, a = z, { visible: p, handleClose: I } = K({ emit: k, props: a, field: "visible" }), { handleSizeChange: j, handleCurrentChange: A, total: B, setTotalPage: S, queryPage: c } = Q({ fetchHook: w }), { maxHeight: q } = W({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, v);
  P(() => a.visible, (l) => {
    l && w();
  }, { immediate: true });
  const D = y(() => a.month && s(s(a.month)).startOf("month").valueOf()), E = y(() => a.month && s(s(a.month)).endOf("month").valueOf()), u = h(false), b = h([]);
  async function w() {
    try {
      u.value = true;
      const l = Object.assign({ projectId: a.projectId, month: a.month }, c), { content: t, totalElements: d } = await G(l);
      b.value = t.map((r, f) => (r.rowId = f + "" + Math.random(), r)), S(d);
    } catch {
      console.log("获取详情列表失败");
    } finally {
      u.value = false;
    }
  }
  return (l, t) => {
    const d = $, r = J, f = x("common-table"), H = U, N = x("common-drawer"), _ = F("parse-time"), O = Y;
    return C(), T(N, { ref_key: "drawerRef", ref: v, title: "构件生产记录", modelValue: e(p), "onUpdate:modelValue": t[0] || (t[0] = (g) => L(p) ? p.value = g : null), direction: "rtl", "before-close": e(I), size: "90%" }, { titleAfter: o(() => [n(d, { effect: "plain", size: "large" }, { default: o(() => [t[1] || (t[1] = i("span", null, "统计日期：", -1)), m(i("span", null, null, 512), [[_, { val: D.value, fmt: "{y}-{m}-{d}" }]]), t[2] || (t[2] = M(" ~ ")), m(i("span", null, null, 512), [[_, { val: E.value, fmt: "{y}-{m}-{d}" }]])]), _: 1, __: [1, 2] })]), titleRight: o(() => t[3] || (t[3] = [])), content: o(() => [m((C(), T(f, { data: b.value, "data-format": e(Z)[e(V).ARTIFACT.V], "max-height": e(q), style: { width: "100%" } }, { default: o(() => [n(r, { label: "序号", type: "index", align: "center", width: "60" }), n(e(X), { showProject: "", showMonomer: "" }), n(e(ee), { productType: e(V).ARTIFACT.V, unShowField: ["remark", "surfaceArea"] }, { quantity: o(() => [n(r, { prop: "quantity", label: "数量", align: "center", "min-width": "70px" })]), _: 1 }, 8, ["productType"]), n(r, { prop: "createTime", "show-overflow-tooltip": true, label: "生产日期", align: "center", width: "120px" }, { default: o(({ row: g }) => [m(i("span", null, null, 512), [[_, { val: g.createTime, fmt: "{y}-{m}-{d}" }]])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[O, u.value]]), n(H, { total: e(B), "current-page": e(c).pageNumber, "page-size": e(c).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: e(j), onCurrentChange: e(A) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  me as default
};
