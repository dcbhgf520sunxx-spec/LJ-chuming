import { inject as F } from "vue";
import { ref as u } from "vue";
import { computed as G } from "vue";
import { resolveComponent as f } from "vue";
import { resolveDirective as g } from "vue";
import { openBlock as w } from "vue";
import { createBlock as v } from "vue";
import { withCtx as a } from "vue";
import { createVNode as e } from "vue";
import { createTextVNode as x } from "vue";
import { toDisplayString as C } from "vue";
import { withDirectives as s } from "vue";
import { unref as t } from "vue";
import { createElementVNode as T } from "vue";
import { isRef as K } from "vue";
import { ElTag as Q } from "element-plus";
import { ElTableColumn as W } from "element-plus";
import { ElPagination as X } from "element-plus";
import { vLoading as Y } from "element-plus";
import { b as Z } from "../../../../../../modules/order-tracking-a52bc8e9.js";
import { u as $, J as ee, o as te, ba as ae } from "../../../../../../shared/runtime.js";
const ie = { __name: "collection-detail-drawer", props: { visible: { type: Boolean, default: false }, monthTypeLabel: { type: String, default: "" }, projectName: { type: String, default: "" }, projectId: { type: Number, default: 0 }, monthType: { type: [Number, null], default: void 0 } }, emits: ["update:visible", "refresh"], setup(c, { emit: z }) {
  const j = F("permission"), h = u(), S = z, n = c, { visible: p, handleClose: k } = $({ emit: S, props: n, field: "visible", showHook: L }), { handleSizeChange: N, handleCurrentChange: V, total: B, setTotalPage: H, queryPage: m } = ee({ fetchHook: y }), I = G(() => ({ projectId: n.projectId, monthType: n.monthType })), { maxHeight: D } = te({ mainBox: ".collection-detail-drawer", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, paginate: true }, () => h.value.loaded), _ = u([]), d = u(false);
  function L() {
    y();
  }
  function P(o) {
    return ae(o, { props: ["collectionAmount"] });
  }
  async function y() {
    try {
      d.value = true;
      const { content: o, totalElements: r } = await Z({ projectId: n.projectId, monthType: n.monthType, ...m });
      _.value = o || [], H(r);
    } catch (o) {
      console.log(o);
    } finally {
      d.value = false;
    }
  }
  return (o, r) => {
    const b = Q, R = f("print-table"), l = W, A = f("common-table"), E = X, U = f("common-drawer"), q = g("permission"), M = g("parse-time"), J = g("thousand"), O = Y;
    return w(), v(U, { ref_key: "drawerRef", ref: h, title: "收款明细", modelValue: t(p), "onUpdate:modelValue": r[0] || (r[0] = (i) => K(p) ? p.value = i : null), direction: "rtl", "before-close": t(k), size: "950px", "custom-class": "collection-detail-drawer" }, { titleAfter: a(() => [e(b, { size: "large", effect: "plain" }, { default: a(() => [x("项目：" + C(c.projectName), 1)]), _: 1 }), e(b, { type: "success", size: "large", effect: "plain" }, { default: a(() => [x(C(c.monthTypeLabel), 1)]), _: 1 })]), content: a(() => [s(e(R, { "api-key": "unitOrderTrackingCollection", params: I.value, type: "warning", class: "filter-item", style: { "margin-bottom": "10px", width: "450px", display: "flex" } }, null, 8, ["params"]), [[q, t(j).print]]), s((w(), v(A, { data: _.value, "max-height": t(D), "show-summary": "", "summary-method": P, style: { width: "100%" } }, { default: a(() => [e(l, { label: "序号", type: "index", align: "center", width: "60" }), e(l, { prop: "collectionDate", align: "center", width: "100", label: "收款日期" }, { default: a(({ row: i }) => [s(T("span", null, null, 512), [[M, { val: i.collectionDate, fmt: "{y}-{m}-{d}" }]])]), _: 1 }), e(l, { prop: "collectionAmount", align: "right", "min-width": "100", label: "收款金额（元）" }, { default: a(({ row: i }) => [s(T("span", null, null, 512), [[J, { val: i.collectionAmount || 0 }]])]), _: 1 }), e(l, { "show-overflow-tooltip": "", prop: "collectionUnit", label: "收款单位", align: "center", "min-width": "120px" }), e(l, { "show-overflow-tooltip": "", prop: "paymentUnit", label: "付款单位", align: "center", "min-width": "120px" })]), _: 1 }, 8, ["data", "max-height"])), [[O, d.value]]), e(E, { total: t(B), "current-page": t(m).pageNumber, "page-size": t(m).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: t(N), onCurrentChange: t(V) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  ie as default
};
