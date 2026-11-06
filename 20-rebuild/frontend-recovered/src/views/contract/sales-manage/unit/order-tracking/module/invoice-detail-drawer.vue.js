import { inject as F } from "vue";
import { ref as u } from "vue";
import { computed as G } from "vue";
import { resolveComponent as f } from "vue";
import { resolveDirective as g } from "vue";
import { openBlock as b } from "vue";
import { createBlock as w } from "vue";
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
import { c as Z } from "../../../../../../modules/order-tracking-a52bc8e9.js";
import { u as $, J as ee, o as te, ba as ae } from "../../../../../../shared/runtime.js";
const le = { __name: "invoice-detail-drawer", props: { visible: { type: Boolean, default: false }, monthTypeLabel: { type: String, default: "" }, projectName: { type: String, default: "" }, projectId: { type: Number, default: 0 }, monthType: { type: [Number, null], default: void 0 } }, emits: ["update:visible", "refresh"], setup(c, { emit: z }) {
  const j = F("permission"), h = u(), S = z, o = c, { visible: p, handleClose: k } = $({ emit: S, props: o, field: "visible", showHook: L }), { handleSizeChange: I, handleCurrentChange: N, total: V, setTotalPage: B, queryPage: m } = ee({ fetchHook: v }), H = G(() => ({ projectId: o.projectId, monthType: o.monthType })), { maxHeight: D } = te({ mainBox: ".invoice-detail-drawer", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, paginate: true }, () => h.value.loaded), _ = u([]), d = u(false);
  function L() {
    v();
  }
  function P(n) {
    return ae(n, { props: ["actualInvoiceAmount"] });
  }
  async function v() {
    try {
      d.value = true;
      const { content: n, totalElements: r } = await Z({ projectId: o.projectId, monthType: o.monthType, ...m });
      _.value = n || [], B(r);
    } catch (n) {
      console.log(n);
    } finally {
      d.value = false;
    }
  }
  return (n, r) => {
    const y = Q, R = f("print-table"), i = W, A = f("common-table"), E = X, U = f("common-drawer"), q = g("permission"), M = g("parse-time"), J = g("thousand"), O = Y;
    return b(), w(U, { ref_key: "drawerRef", ref: h, title: "开票明细", modelValue: t(p), "onUpdate:modelValue": r[0] || (r[0] = (l) => K(p) ? p.value = l : null), direction: "rtl", "before-close": t(k), size: "950px", "custom-class": "invoice-detail-drawer" }, { titleAfter: a(() => [e(y, { size: "large", effect: "plain" }, { default: a(() => [x("项目：" + C(c.projectName), 1)]), _: 1 }), e(y, { type: "success", size: "large", effect: "plain" }, { default: a(() => [x(C(c.monthTypeLabel), 1)]), _: 1 })]), content: a(() => [s(e(R, { "api-key": "unitOrderTrackingInvoice", params: H.value, type: "warning", class: "filter-item", style: { "margin-bottom": "10px", width: "450px", display: "flex" } }, null, 8, ["params"]), [[q, t(j).print]]), s((b(), w(A, { data: _.value, "max-height": t(D), "show-summary": "", "summary-method": P, style: { width: "100%" } }, { default: a(() => [e(i, { label: "序号", type: "index", align: "center", width: "60" }), e(i, { prop: "invoiceDate", align: "center", width: "100", label: "开票日期" }, { default: a(({ row: l }) => [s(T("span", null, null, 512), [[M, { val: l.invoiceDate, fmt: "{y}-{m}-{d}" }]])]), _: 1 }), e(i, { prop: "actualInvoiceAmount", align: "right", "min-width": "100", label: "实际开票金额（元）" }, { default: a(({ row: l }) => [s(T("span", null, null, 512), [[J, { val: l.actualInvoiceAmount || 0 }]])]), _: 1 }), e(i, { "show-overflow-tooltip": "", prop: "invoiceUnit", label: "开票单位", align: "center", "min-width": "120px" }), e(i, { "show-overflow-tooltip": "", prop: "collectionUnit", label: "收票单位", align: "center", "min-width": "120px" })]), _: 1 }, 8, ["data", "max-height"])), [[O, d.value]]), e(E, { total: t(V), "current-page": t(m).pageNumber, "page-size": t(m).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: t(I), onCurrentChange: t(N) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  le as default
};
