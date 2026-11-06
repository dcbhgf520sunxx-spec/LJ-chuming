import { ref as b } from "vue";
import { inject as j } from "vue";
import { watch as B } from "vue";
import { resolveComponent as N } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as p } from "vue";
import { createVNode as e } from "vue";
import { withCtx as l } from "vue";
import { createTextVNode as I } from "vue";
import { toDisplayString as c } from "vue";
import { unref as a } from "vue";
import { Fragment as T } from "vue";
import { createElementVNode as A } from "vue";
import { createCommentVNode as P } from "vue";
import { ElTag as q } from "element-plus";
import { ElTableColumn as H } from "element-plus";
import { ElTooltip as O } from "element-plus";
import { _ as Q, o as Y, x as L, D as g, cO as z, jP as m, jR as G, jl as K, dp as x, cE as J, jQ as W, p as X } from "../../../../shared/runtime.js";
import { u as Z } from "../../../../modules/useTableTotal-3d22365a.js";
import { c as $ } from "../../../../modules/right-page-12d526dc.js";
const ee = { key: 0 }, te = { class: "pointer" }, ae = { key: 0 }, oe = { key: 1 }, le = { __name: "RightPage", emits: ["print-success"], setup(ne, { emit: C }) {
  const E = C, _ = b(), { orderId: y, itemData: n } = j("topLevel"), { maxHeight: D } = Y({ extraBox: ".header-container", extraHeight: 100 }), { crud: u, CRUD: U } = L({ title: "入库明细", crudApi: { ...$ }, queryOnPresenterCreated: false, dataPath: "" }, _);
  B(() => y.value, async (i, r) => {
    i && i !== r && (u.query.id = i, await u.toQuery()), S();
  });
  const R = b([["amount", ["to-thousand", g.YUAN]], ["realityInboundAmount", ["to-thousand", g.YUAN]], ["rejectAmount", ["to-thousand", g.YUAN]], ["amountExcludingVat", ["to-thousand", g.YUAN]], ["applicantDate", ["parse-time", "{y}-{m}-{d}"]]]), { getSummaries: V } = Z(false, { defineData: ["amount", "amountExcludingVat", "rejectAmount", "realityInboundAmount", "quantity", "mete"] });
  U.HOOK.handleRefresh = async (i, { data: r }) => {
    var h;
    await z(r, { multipleSpec: true }), r.forEach((w) => {
      w.basicClass = w.basicClassEnum;
    }), n.value.materialType & m.MANUFACTURED.V || ((h = n.value.sourceRow) == null ? void 0 : h.materialType) & m.MANUFACTURED.V ? i.data = await G(r, { toNum: true }, { mete: ["mete"], amount: ["price", "priceExcludingVat"] }) : i.data = await K(r, { toSmallest: false, toNum: true }, { mete: ["mete", "actualReceivedMete"], amount: ["price", "priceExcludingVat"] });
  };
  const v = b();
  function S() {
    v.value = Math.random();
  }
  function k() {
    E("print-success");
  }
  return (i, r) => {
    const h = q, w = N("print-table"), t = H, M = O, F = N("common-table");
    return s(), p("div", { key: v.value, class: "right animate__fadeIn" }, [e(x, { "header-title": "入库明细" }), e(x, { "header-title": "" }, { subTitle: l(() => [e(h, { type: "primary" }, { default: l(() => [I(c("采购合同号：" + a(n).purchaseContractNumber) + "   |   " + c("签约主体：" + a(n).contractSignBodyName), 1)]), _: 1 })]), headerRight: l(() => {
      var d, f;
      return [e(w, { "api-key": a(n).materialType & a(m).MANUFACTURED.V || ((f = (d = a(n)) == null ? void 0 : d.sourceRow) == null ? void 0 : f.materialType) & a(m).MANUFACTURED.V ? "newManufacturedStorageDetails" : "newStorageDetails", disabled: a(u).data.length === 0, params: { orderId: a(y) }, size: "default", type: "warning", onSuccess: k }, null, 8, ["api-key", "disabled", "params"])];
    }), _: 1 }), e(F, { ref_key: "tableRef", ref: _, data: a(u).data, "data-format": R.value, "empty-text": a(u).emptyText, "max-height": a(D), "summary-method": a(V), "show-summary": "", stripe: "" }, { default: l(() => {
      var d, f;
      return [e(t, { align: "center", label: "序号", type: "index", width: "60" }), a(n).materialType & a(m).MANUFACTURED.V || ((f = (d = a(n)) == null ? void 0 : d.sourceRow) == null ? void 0 : f.materialType) & a(m).MANUFACTURED.V ? (s(), p(T, { key: 0 }, [e(t, { align: "center", label: "名称", prop: "manufacturedName", "show-overflow-tooltip": "", width: "100" }), e(t, { align: "center", label: "材料类型", prop: "basicClass" }, { default: l(({ row: o }) => [A("span", null, c(a(J).VL[o.basicClassEnum]), 1)]), _: 1 }), e(t, { align: "center", label: "分类名称", prop: "finishedGoodsTypeName", "show-overflow-tooltip": "", width: "100" }), e(t, { align: "center", label: "编号", prop: "manufacturedSn", "show-overflow-tooltip": "", width: "100" }), e(t, { align: "center", label: "规格", "min-width": "120", prop: "specification", "show-overflow-tooltip": "" }), e(t, { align: "center", label: "材质", prop: "material", "show-overflow-tooltip": "", width: "100" }), e(t, { align: "center", label: "入库数量", prop: "quantity" }), e(t, { align: "center", label: "核算单位", prop: "accountingUnit" }, { default: l(({ row: o }) => [o.wageQuotaType ? (s(), p("span", ee, c(a(W).V[o.wageQuotaType].C_UNIT), 1)) : P("", true)]), _: 1 }), e(t, { align: "center", label: "核算量", prop: "mete" })], 64)) : (s(), p(T, { key: 1 }, [e(t, { align: "left", label: "物料名称", prop: "classifyName", "show-overflow-tooltip": "" }, { default: l(({ row: o }) => [e(M, { content: o.classifyFullName === o.classifyName ? o.classification : o.classifyFullName, placement: "top" }, { default: l(() => [A("span", te, c(o.classifyName), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), e(t, { align: "center", label: "规格", prop: "specification", "show-overflow-tooltip": "" }), e(t, { align: "center", label: "品牌", prop: "brand", "show-overflow-tooltip": "" }), e(t, { align: "center", label: "颜色", prop: "color", "show-overflow-tooltip": "" }), e(t, { label: `计量
单位`, align: "center", prop: "measureUnit", width: "60" }), e(t, { align: "center", label: "数量", prop: "quantity", width: "90" }), e(t, { label: `核算
单位`, align: "center", prop: "accountingUnit", width: "60" }), e(t, { align: "center", label: "核算量", prop: "mete", width: "90" }), e(t, { align: "center", label: "实收量", prop: "actualReceivedMete", width: "90" })], 64)), e(t, { label: `不含税
单价`, align: "center", prop: "priceExcludingVat", "show-overflow-tooltip": "", width: "100" }), e(t, { align: "center", label: "含税单价", prop: "price", "show-overflow-tooltip": "", width: "100" }), e(t, { label: `不含税
金额`, align: "center", prop: "amountExcludingVat", "show-overflow-tooltip": "" }), e(t, { align: "center", label: "含税金额", prop: "amount", "show-overflow-tooltip": "" }), e(t, { align: "center", label: "退货金额", prop: "rejectAmount", "show-overflow-tooltip": "" }), e(t, { align: "center", label: "调整金额", prop: "differentAmount" }), e(t, { label: `实际入库
含税金额`, align: "center", prop: "realityInboundAmount" }), e(t, { align: "center", label: "办理人", prop: "applicant.name", width: "100" }), e(t, { align: "center", label: "办理日期", prop: "applicantDate", "show-overflow-tooltip": "", width: "140" }), e(t, { align: "center", label: "审核人", prop: "reviewer.name", width: "100" }), e(t, { align: "center", label: "审核日期", prop: "reviewerDate", "show-overflow-tooltip": "", width: "140" }, { default: l(({ row: o }) => [o.reviewerDate && o.reviewerDate !== "-" ? (s(), p("span", ae, c(a(X)(o.reviewerDate, "{y}-{m}-{d}")), 1)) : (s(), p("span", oe, "-"))]), _: 1 }), e(t, { align: "center", label: "入库单号", prop: "inboundSerialNumber", "show-overflow-tooltip": "", width: "160" }), e(t, { align: "center", label: "项目", prop: "project.shortName", "show-overflow-tooltip": "", width: "160" })];
    }), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height", "summary-method"])]);
  };
} }, ce = Q(le, [["__scopeId", "data-v-ffb74adf"]]);
export {
  ce as default
};
