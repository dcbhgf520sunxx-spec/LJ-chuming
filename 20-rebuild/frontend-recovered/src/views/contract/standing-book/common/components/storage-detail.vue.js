import { ref as x } from "vue";
import { resolveComponent as _ } from "vue";
import { openBlock as m } from "vue";
import { createBlock as M } from "vue";
import { withCtx as n } from "vue";
import { createVNode as e } from "vue";
import { createTextVNode as H } from "vue";
import { toDisplayString as u } from "vue";
import { unref as a } from "vue";
import { createElementVNode as h } from "vue";
import { createElementBlock as w } from "vue";
import { Fragment as D } from "vue";
import { createCommentVNode as R } from "vue";
import { ElTag as L } from "element-plus";
import { ElTableColumn as I } from "element-plus";
import { ElTooltip as Y } from "element-plus";
import { l as q, _ as P, u as Q, kc as z, D as d, o as O, jP as y, jQ as G, cO as J, jR as K, jl as W } from "../../../../../shared/runtime.js";
import { u as X } from "../../../../../modules/useTableTotal-3d22365a.js";
function Z(g) {
  return q({ url: "/api/project/v2/projectLedger/supplierLedger/inboundList", method: "get", params: g });
}
const $ = { class: "head-container" }, ee = { class: "table-container" }, te = { key: 0 }, ae = { class: "pointer" }, oe = { __name: "storage-detail", props: { modelValue: { type: Boolean, required: true } }, emits: ["update:modelValue"], setup(g, { emit: N }) {
  const E = g, V = N, p = x([]), A = async () => {
    var f, b;
    try {
      const { content: r } = await Z({ orderId: (f = l.rowDetail) == null ? void 0 : f.id }), i = await J(r, { multipleSpec: true });
      i.forEach((t) => {
        t.basicClass = t.basicClassEnum;
      }), ((b = l.rowDetail) == null ? void 0 : b.materialType) & y.MANUFACTURED.V ? p.value = await K(i, { toNum: true }, { mete: ["mete"], amount: ["price", "priceExcludingVat"] }) : p.value = await W(i, { toSmallest: false, toNum: true }, { mete: ["mete", "actualReceivedMete"], amount: ["price", "priceExcludingVat"] });
    } catch (r) {
      console.log(r);
    }
  }, { visible: T, handleClose: C } = Q({ emit: V, props: E, showHook: A }), { crud: l } = z(), U = x([["amount", ["to-thousand", d.YUAN]], ["amountExcludingVat", ["to-thousand", d.YUAN]], ["rejectAmount", ["to-thousand", d.YUAN]], ["differentAmount", ["to-thousand", d.YUAN]], ["applicantDate", ["parse-time", "{y}-{m}-{d}"]], ["reviewerDate", ["parse-time", "{y}-{m}-{d}"]]]), { getSummaries: B } = X(false, { defineData: ["amount", "rejectAmount", "differentAmount", "amountExcludingVat"] }), { maxHeight: S } = O({ mainBox: ".storage-detail", extraBox: [".el-drawer__header", ".head-container"], wrapperBox: [".table-container"], paginate: false, navbar: false, minHeight: 300, extraHeight: 40, clientHRepMainH: true }, p.value);
  return (f, b) => {
    const r = L, i = _("print-table"), t = I, j = Y, k = _("common-table"), F = _("common-drawer");
    return m(), M(F, { appendToBody: true, "before-close": a(C), visible: a(T), "custom-class": "storage-detail", size: "90%", title: "入库明细" }, { titleAfter: n(() => [e(r, null, { default: n(() => {
      var s, c;
      return [H(u("合同编号：" + a(l).rowDetail.serialNumber) + "   |   " + u("签约主体：" + ((c = (s = a(l).rowDetail) == null ? void 0 : s.branchCompany) == null ? void 0 : c.name)), 1)];
    }), _: 1 })]), content: n(() => {
      var s, c;
      return [h("div", $, [e(i, { params: { orderId: (s = a(l).rowDetail) == null ? void 0 : s.id, isContract: true }, "api-key": ((c = a(l).rowDetail) == null ? void 0 : c.materialType) & a(y).MANUFACTURED.V ? "newManufacturedStorageDetails" : "newStorageDetails", size: "default", type: "warning" }, null, 8, ["params", "api-key"])]), h("div", ee, [e(k, { ref: "tableRef", data: p.value, "data-format": U.value, "max-height": a(S), "summary-method": a(B), "show-summary": "", stripe: "" }, { default: n(() => {
        var v;
        return [e(t, { align: "center", label: "序号", type: "index", width: "60" }), ((v = a(l).rowDetail) == null ? void 0 : v.materialType) & a(y).MANUFACTURED.V ? (m(), w(D, { key: 0 }, [e(t, { align: "center", label: "名称", prop: "manufacturedName", "show-overflow-tooltip": "" }), e(t, { align: "center", label: "规格", prop: "specification", "min-width": "120", "show-overflow-tooltip": "" }), e(t, { align: "center", label: "入库数量", prop: "quantity" }), e(t, { align: "center", label: "核算单位", prop: "accountingUnit" }, { default: n(({ row: o }) => [o.wageQuotaType ? (m(), w("span", te, u(a(G).V[o.wageQuotaType].C_UNIT), 1)) : R("", true)]), _: 1 }), e(t, { align: "center", label: "核算量", prop: "mete" }), e(t, { align: "center", label: "不含税单价", prop: "priceExcludingVat" }), e(t, { align: "center", label: "含税单价", prop: "price" }), e(t, { align: "center", label: "不含税金额", prop: "amountExcludingVat", width: "120" }), e(t, { align: "center", label: "含税金额", prop: "amount", width: "120" })], 64)) : (m(), w(D, { key: 1 }, [e(t, { align: "left", label: "物料名称", prop: "classifyName", "show-overflow-tooltip": "" }, { default: n(({ row: o }) => [e(j, { content: o.classifyFullName === o.classifyName ? o.classification : o.classifyFullName, placement: "top" }, { default: n(() => [h("span", ae, u(o.classifyName), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), e(t, { align: "center", label: "规格", prop: "specification", "show-overflow-tooltip": "" }), e(t, { align: "center", label: "品牌", prop: "brand", "show-overflow-tooltip": "" }), e(t, { align: "center", label: "颜色", prop: "color", "show-overflow-tooltip": "" }), e(t, { align: "center", label: "计量单位", prop: "measureUnit" }), e(t, { align: "center", label: "入库数量", prop: "quantity" }), e(t, { align: "center", label: "核算单位", prop: "accountingUnit" }), e(t, { align: "center", label: "核算量", prop: "mete" }), e(t, { align: "center", label: "不含税单价", prop: "priceExcludingVat" }), e(t, { align: "center", label: "含税单价", prop: "price" }), e(t, { align: "center", label: "不含税金额", prop: "amountExcludingVat", width: "120" }), e(t, { align: "center", label: "含税金额", prop: "amount", width: "120" }), e(t, { align: "center", label: "退货金额", prop: "rejectAmount", width: "120" }), e(t, { align: "center", label: "调整金额", prop: "differentAmount", width: "120" })], 64)), e(t, { align: "center", label: "办理人", prop: "applicant.name" }), e(t, { align: "center", label: "办理日期", prop: "applicantDate", "show-overflow-tooltip": "" }), e(t, { align: "center", label: "审核人", prop: "reviewer.name" }), e(t, { align: "center", label: "审核日期", prop: "reviewerDate", "show-overflow-tooltip": "" }), e(t, { align: "center", label: "入库单号", prop: "inboundSerialNumber", "show-overflow-tooltip": "" }), e(t, { align: "center", label: "项目", prop: "project.shortName", "show-overflow-tooltip": "" })];
      }), _: 1 }, 8, ["data", "data-format", "max-height", "summary-method"])])];
    }), _: 1 }, 8, ["before-close", "visible"]);
  };
} }, ie = P(oe, [["__scopeId", "data-v-efde19e6"]]);
export {
  ie as default
};
