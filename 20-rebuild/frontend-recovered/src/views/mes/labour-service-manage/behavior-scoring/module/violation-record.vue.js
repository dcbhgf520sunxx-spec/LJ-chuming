import { ref as m } from "vue";
import { inject as j } from "vue";
import { resolveComponent as d } from "vue";
import { resolveDirective as E } from "vue";
import { openBlock as u } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as o } from "vue";
import { createVNode as t } from "vue";
import { createTextVNode as n } from "vue";
import { toDisplayString as a } from "vue";
import { withDirectives as w } from "vue";
import { unref as s } from "vue";
import { createElementBlock as H } from "vue";
import { createCommentVNode as P } from "vue";
import { isRef as z } from "vue";
import { ElTag as A } from "element-plus";
import { ElTableColumn as L } from "element-plus";
import { vLoading as M } from "element-plus";
import { g as U } from "../../../../../modules/behavior-scoring-beef2568.js";
import { u as F, o as O, nZ as Y, p as Z, ba as G, D as J } from "../../../../../shared/runtime.js";
const K = { key: 0 }, $ = { __name: "violation-record", props: { visible: { type: Boolean, default: false }, userInfo: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(i, { emit: v }) {
  const g = v, p = i, k = m(), D = m(), f = m(), b = j("query"), { visible: c, handleClose: N } = F({ emit: g, props: p, field: "visible", showHook: V });
  async function I() {
    try {
      const r = { userId: p.userInfo.userId, year: b.year };
      f.value = await U(r);
    } catch (r) {
      console.log(r);
    }
  }
  const { maxHeight: x } = O({ paginate: true });
  function R(r) {
    return G(r, { props: ["behaviorScore", ["penalty", J.YUAN]], toThousandFields: ["penalty"] });
  }
  function V() {
    I();
  }
  return (r, y) => {
    const h = A, S = d("print-table"), l = L, q = d("common-table"), C = d("common-drawer"), T = E("permission"), B = M;
    return u(), _(C, { ref_key: "drawerRef", ref: k, title: "违章记录", modelValue: s(c), "onUpdate:modelValue": y[0] || (y[0] = (e) => z(c) ? c.value = e : null), direction: "rtl", "before-close": s(N), size: "60%" }, { titleAfter: o(() => [t(h, null, { default: o(() => {
      var e;
      return [n("用人单位：" + a(((e = i.userInfo) == null ? void 0 : e.supplierName) || "-"), 1)];
    }), _: 1 }), t(h, null, { default: o(() => {
      var e;
      return [n("姓名：" + a(((e = i.userInfo) == null ? void 0 : e.name) || "-"), 1)];
    }), _: 1 })]), titleRight: o(() => {
      var e;
      return [w(t(S, { "api-key": "violationRecordReport", params: { userId: (e = i.userInfo) == null ? void 0 : e.userId, year: s(b).year }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[T, s(Y).violationRecordPrint]])];
    }), content: o(() => [w((u(), _(q, { data: f.value, "max-height": s(x), "show-summary": "", "summary-method": R, style: { width: "100%" } }, { default: o(() => [t(l, { label: "序号", type: "index", align: "center", width: "60" }), t(l, { key: "recordDate", prop: "recordDate", "show-overflow-tooltip": "", align: "center", label: "记录日期" }, { default: o((e) => [e.row.recordDate ? (u(), H("span", K, a(s(Z)(e.row.recordDate, "{y}-{m}-{d}")), 1)) : P("", true)]), _: 1 }), t(l, { key: "qhseNumber", prop: "qhseNumber", "show-overflow-tooltip": "", align: "center", label: "安环编号" }, { default: o((e) => [n(a(e.row.qhseNumber || "-"), 1)]), _: 1 }), t(l, { key: "recorderName", prop: "recorderName", "show-overflow-tooltip": "", align: "center", label: "记录人" }, { default: o((e) => [n(a(e.row.recorderName || "-"), 1)]), _: 1 }), t(l, { key: "behaviorScore", prop: "behaviorScore", "show-overflow-tooltip": "", align: "center", label: "行为扣分" }, { default: o((e) => [n(a(e.row.behaviorScore), 1)]), _: 1 }), t(l, { key: "penalty", prop: "penalty", "show-overflow-tooltip": "", align: "center", label: "处罚（元）" }, { default: o((e) => [n(a(e.row.penalty), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[B, D.value]])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  $ as default
};
