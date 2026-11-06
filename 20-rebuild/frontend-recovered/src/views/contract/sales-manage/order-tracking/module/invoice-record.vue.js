import { computed as w } from "vue";
import { watch as j } from "vue";
import { ref as p } from "vue";
import { resolveComponent as m } from "vue";
import { resolveDirective as E } from "vue";
import { openBlock as I } from "vue";
import { createBlock as q } from "vue";
import { withCtx as l } from "vue";
import { createElementVNode as _ } from "vue";
import { withDirectives as A } from "vue";
import { createVNode as e } from "vue";
import { unref as a } from "vue";
import { toDisplayString as L } from "vue";
import { ElTableColumn as M } from "element-plus";
import { ElPagination as O } from "element-plus";
import { i as U } from "../../../../../modules/order-tracking-9be524cd.js";
import { t as F, u as J, J as G, c3 as K, bD as Q, o as W } from "../../../../../shared/runtime.js";
const X = { class: "print-wrap" }, ee = { __name: "invoice-record", props: { modelValue: { type: Boolean, require: true }, detailInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, emits: ["update:modelValue"], setup(b, { emit: y }) {
  const x = y, { decimalPrecision: C } = F(), r = b, { visible: d, handleClose: R } = J({ emit: x, props: r }), { handleSizeChange: z, handleCurrentChange: B, total: D, setTotalPage: S, queryPage: s } = G({ fetchHook: f }), u = w(() => {
    var o;
    return { projectId: (o = r.detailInfo.project) == null ? void 0 : o.id, auditStatus: K.PASS.V };
  });
  j(d, (o) => {
    o && f();
  });
  const h = p([]), g = p(), v = p(false), H = w(() => [["invoiceType", ["parse-enum", Q]], ["invoiceDate", ["parse-time", "{y}-{m}-{d}"]], ["invoiceAmount", ["to-thousand", C.value.contract]], ["taxRate", ["to-fixed", 2]]]), { maxHeight: P } = W({ mainBox: ".invoice-record", extraBox: ".el-dialog__header", wrapperBox: ".el-dialog__body", extraHeight: "5vh", minHeight: 300, navbar: false, clientHRepMainH: true }, g);
  async function f() {
    let o = [];
    v.value = true;
    try {
      const { content: i = [], totalElements: c } = await U({ ...u.value, ...s });
      o = i, S(c);
    } catch (i) {
      console.log("获取开票记录失败", i);
    } finally {
      h.value = o, v.value = false;
    }
  }
  return (o, i) => {
    const c = m("print-table"), t = M, k = m("common-table"), N = O, T = m("common-dialog"), V = E("permission");
    return I(), q(T, { ref_key: "dialogRef", ref: g, title: "开票记录", "append-to-body": "", visible: a(d), width: "1300px", "close-on-click-modal": false, "before-close": a(R), "custom-class": "invoice-record", "show-close": "", top: "10vh" }, { titleRight: l(() => {
      var n;
      return [_("div", X, [A(e(c, { "api-key": "projectInvoiceDetail", params: { ...u.value }, size: "default", type: "warning" }, null, 8, ["params"]), [[V, (n = r.permission) == null ? void 0 : n.print]])])];
    }), default: l(() => [e(k, { data: h.value, "data-format": H.value, "max-height": a(P) }, { default: l(() => [e(t, { label: "序号", type: "index", align: "center", width: "60" }), e(t, { prop: "invoiceDate", label: "开票日期", align: "center", width: "100", "show-overflow-tooltip": "" }), e(t, { prop: "invoiceAmount", label: "开票额", align: "center", "min-width": "120", "show-overflow-tooltip": "" }), e(t, { prop: "invoiceType", label: "开票类型", align: "center", width: "110", "show-overflow-tooltip": "" }), e(t, { prop: "taxRate", label: "税率", align: "center", width: "70", "show-overflow-tooltip": "" }, { default: l(({ row: n }) => [_("span", null, L(n.taxRate) + "%", 1)]), _: 1 }), e(t, { prop: "invoiceUnit", label: "购方单位", align: "center", "min-width": "140", "show-overflow-tooltip": "" }), e(t, { prop: "collectionUnit", label: "销售单位", align: "center", "min-width": "140", "show-overflow-tooltip": "" }), e(t, { prop: "invoiceNo", label: "发票编号", align: "center", "min-width": "100", "show-overflow-tooltip": "" }), e(t, { prop: "writtenByName", label: "办理人", align: "center", "min-width": "100", "show-overflow-tooltip": "" }), e(t, { prop: "auditorName", label: "审核人", align: "center", "min-width": "100", "show-overflow-tooltip": "" })]), _: 1 }, 8, ["data", "data-format", "max-height"]), e(N, { total: a(D), "current-page": a(s).pageNumber, "page-size": a(s).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: a(z), onCurrentChange: a(B) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["visible", "before-close"]);
  };
} };
export {
  ee as default
};
