import { _ as H, o as $, eb as F, G as O, e2 as G, ec as W, bN as z, j0 as E } from "../../../../../../shared/runtime.js";
import { inject as J } from "vue";
import { ref as c } from "vue";
import { computed as K } from "vue";
import { provide as Q } from "vue";
import { resolveComponent as X } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as r } from "vue";
import { createElementVNode as m } from "vue";
import { withDirectives as Y } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as l } from "vue";
import { createVNode as n } from "vue";
import { toDisplayString as i } from "vue";
import { createTextVNode as j } from "vue";
import { createCommentVNode as u } from "vue";
import { unref as h } from "vue";
import { resolveDynamicComponent as Z } from "vue";
import { Fragment as ee } from "vue";
import { defineAsyncComponent as I } from "vue";
import { ElTableColumn as te } from "element-plus";
import { ElTag as ae } from "element-plus";
import { vLoading as ne } from "element-plus";
import { u as oe } from "../../../../../../modules/useTableTotal-3d22365a.js";
import { W as le } from "../../../../../../modules/contract-9b18cc88.js";
import { b as se } from "../../../../../../modules/self-healing-29154caf.js";
const ce = { class: "table-container" }, ie = { key: 0 }, re = ["onClick"], ue = ["onClick"], pe = ["onClick"], de = { key: 0 }, me = { __name: "table", setup(_e, { expose: P }) {
  const { maxHeight: A } = $({ paginate: true }), { formData: L } = J("selfParentData"), f = c(false), p = c([]), { requestData: k, total: y } = oe(), C = c({}), x = c(false), d = c(null), S = c(""), v = c(""), R = c({ collection: "secondUnitSelfCollectionDetail", preSettle: "secondUnitSelfPreSettleDetail", expend: "secondUnitSelfInvoiceDetail" });
  c();
  const b = async () => {
    if (!O(le.secondUnit.self.get)) return G("warning", "暂无权限");
    try {
      f.value = true;
      const o = await se({ ...L.value, ...k, level: 2 });
      if (!o) {
        p.value = [];
        return;
      }
      p.value = W(o.content), p.value.forEach((t) => {
        switch (t.businessTypeName = z.VL[t.businessType], t.projectName = t.project.serialNumber + "-" + t.project.shortName, t.status) {
          case 1:
            t.statusName = "进行中";
            break;
          case 2:
            t.statusName = "已暂停";
            break;
          case 4:
            t.statusName = "已完工";
            break;
          default:
            t.statusName = "";
        }
      }), y.value = o.totalElements;
    } catch (o) {
      console.error("获取自合营项目列表失败,", o);
    } finally {
      f.value = false;
    }
  };
  b();
  const V = { record: I(() => E(() => import("../../../common/components/record/index.vue.js"), ["static/js/index-76ebe898.js", "static/js/index-50216080.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/css/index-685b5588.css", "static/css/index-dcd37e93.css", "static/css/el-radio-group-3b9ac3ad.css"])), fundAccount: I(() => E(() => import("./fund-account/index.vue.js"), ["static/js/index-3e8c38da.js", "static/js/index-50216080.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/css/index-685b5588.css", "static/css/index-07653a90.css", "static/css/el-radio-group-3b9ac3ad.css"])) }, B = K(() => V[S.value]), N = (o) => isNaN(o) ? "-" : (o * 100).toFixed(2) + "%", T = () => {
    d.value && (d.value.radioType = v.value, d.value.visible = true);
  }, g = (o, t, a) => {
    S.value = o, C.value = t, v.value = a, T();
  }, U = (o) => {
    o && T();
  };
  return Q("tableItem", { projectInfo: C, mark: v }), P({ getSelfProjectList: b }), (o, t) => {
    const a = te, D = ae, q = X("common-table"), M = ne;
    return s(), r(ee, null, [m("div", ce, [Y((s(), _(q, { data: p.value, "max-height": h(A), border: "", fit: "" }, { default: l(() => [n(a, { align: "center", label: "序号", type: "index", width: "60" }), n(a, { align: "left", label: "项目", "min-width": "160", "show-overflow-tooltip": "" }, { default: l(({ row: { projectName: e } }) => [m("span", null, i(e), 1)]), _: 1 }), n(a, { align: "center", label: "立项日期", prop: "createTime" }), n(a, { align: "center", label: "销售负责人", prop: "salesLeaderName" }), n(a, { align: "center", label: "项目状态", prop: "settlementStatus" }, { default: l(({ row: e }) => [e.settlementStatus === 0 ? (s(), _(D, { key: 0, type: "danger" }, { default: l(() => t[1] || (t[1] = [j("未结算")])), _: 1, __: [1] })) : e.settlementStatus === 1 ? (s(), _(D, { key: 1, type: "success" }, { default: l(() => t[2] || (t[2] = [j("已结算")])), _: 1, __: [2] })) : u("", true)]), _: 1 }), n(a, { align: "center", label: "合同额", "min-width": "100", prop: "amount" }), n(a, { align: "center", label: "结算额", "min-width": "100", prop: "settlementAmount" }, { default: l(({ row: { settlementAmount: e } }) => [e ? (s(), r("span", ie, i(e), 1)) : u("", true)]), _: 1 }), n(a, { align: "center", label: "预结算额", "min-width": "100", prop: "preSettlementAmount" }, { default: l(({ row: e }) => [e.preSettlementAmount ? (s(), r("span", { key: 0, class: "specialText", onClick: (w) => g("record", e, "preSettle") }, i(e.preSettlementAmount), 9, re)) : u("", true)]), _: 1 }), n(a, { align: "center", label: "累计收款", "min-width": "100", prop: "accumulatedCollection" }, { default: l(({ row: e }) => [e.accumulatedCollection ? (s(), r("span", { key: 0, class: "specialText", onClick: (w) => g("record", e, "collection") }, i(e.accumulatedCollection), 9, ue)) : u("", true)]), _: 1 }), n(a, { align: "center", label: "收款比例（%）", "min-width": "100", prop: "collectionRatio" }, { default: l(({ row: e }) => [m("span", null, i(N(e.collectionRatio)), 1)]), _: 1 }), n(a, { align: "center", label: "累计开票", "min-width": "100", prop: "accumulatedInvoice" }, { default: l(({ row: e }) => [e.accumulatedInvoice ? (s(), r("span", { key: 0, class: "specialText", onClick: (w) => g("record", e, "expend") }, i(e.accumulatedInvoice), 9, pe)) : u("", true)]), _: 1 }), n(a, { align: "center", label: "开票比例（%）", "min-width": "100", prop: "invoiceRatio" }, { default: l(({ row: e }) => [m("span", null, i(N(e.invoiceRatio)), 1)]), _: 1 }), n(a, { align: "center", label: "合同（结算）应收", "min-width": "130", prop: "advancesReceived" }, { default: l(({ row: { advancesReceived: e } }) => [e ? (s(), r("span", de, i(e), 1)) : u("", true)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[M, f.value]]), n(F, { "request-data": h(k), total: h(y), onHandleChange: b }, null, 8, ["request-data", "total"])]), (s(), _(Z(B.value), { ref_key: "currentComponentRef", ref: d, visible: x.value, "onUpdate:visible": t[0] || (t[0] = (e) => x.value = e), apikey: R.value, level: 2, onComponentMounted: U }, null, 40, ["visible", "apikey"]))], 64);
  };
} }, ke = H(me, [["__scopeId", "data-v-ccdb6363"]]);
export {
  ke as default
};
