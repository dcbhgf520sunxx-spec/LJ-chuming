import { _ as H, o as O, eb as W, G as z, e2 as G, ec as U, bN as J, j0 as w } from "../../../../../shared/runtime.js";
import { ref as c } from "vue";
import { inject as K } from "vue";
import { computed as Q } from "vue";
import { provide as X } from "vue";
import { resolveComponent as Y } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as r } from "vue";
import { createElementVNode as _ } from "vue";
import { withDirectives as Z } from "vue";
import { createBlock as v } from "vue";
import { withCtx as n } from "vue";
import { createVNode as l } from "vue";
import { toDisplayString as i } from "vue";
import { createTextVNode as B } from "vue";
import { createCommentVNode as u } from "vue";
import { normalizeStyle as ee } from "vue";
import { unref as x } from "vue";
import { resolveDynamicComponent as te } from "vue";
import { Fragment as ae } from "vue";
import { defineAsyncComponent as I } from "vue";
import { nextTick as le } from "vue";
import { ElTableColumn as ne } from "element-plus";
import { ElTag as oe } from "element-plus";
import { vLoading as se } from "element-plus";
import { i as ce } from "../../../../../modules/self-healing-6f411a5c.js";
import { u as ie } from "../../../../../modules/useTableTotal-3d22365a.js";
import { W as re } from "../../../../../modules/contract-9b18cc88.js";
const ue = { class: "table-container" }, pe = { key: 0 }, de = ["onClick"], me = ["onClick"], _e = ["onClick"], ve = ["onClick"], fe = { key: 1 }, be = { key: 0 }, ge = { __name: "table", setup(he, { expose: j }) {
  const f = c(true), { maxHeight: A } = O({ paginate: true }), { formData: L } = K("selfParentData"), b = c(false), p = c([]), { requestData: T, total: S } = ie(), N = c({}), g = c(false), d = c(null), h = c(""), k = c(""), P = c({ collection: "selfExpendCollectionDetail", expend: "selfExpendInvoiceDetail", preSettle: "selfPreSettleDetail" });
  c();
  const y = async () => {
    if (!z(re.self.get)) return G("warning", "暂无权限");
    try {
      b.value = true;
      const o = await ce({ ...L.value, ...T });
      if (!o) {
        p.value = [];
        return;
      }
      p.value = U(o.content), p.value.forEach((t) => {
        switch (t.businessTypeName = J.VL[t.businessType], t.projectName = t.project.serialNumber + "-" + t.project.shortName, t.status) {
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
      }), S.value = o.totalElements;
    } catch (o) {
      console.error("获取自合营项目列表失败,", o);
    } finally {
      b.value = false;
    }
  };
  y();
  const V = { costReport: I(() => w(() => import("./cost-report/index.vue.js"), ["static/js/index-ef9b1da6.js", "static/js/index-50216080.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/css/index-685b5588.css", "static/js/DrawerLeft-0f7d9ef0.js", "static/js/index-a8127339.js", "static/js/useTableTotal-3d22365a.js", "static/js/useTableHeight-90797a0b.js", "static/js/index-d4be09aa.js", "static/css/DrawerLeft-38518929.css", "static/css/index-fe9b5690.css"])), record: I(() => w(() => import("../../common/components/record/index.vue.js"), ["static/js/index-76ebe898.js", "static/js/index-50216080.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/css/index-685b5588.css", "static/css/index-dcd37e93.css", "static/css/el-radio-group-3b9ac3ad.css"])) }, M = Q(() => V[h.value]), D = (o) => isNaN(o) ? "-" : (o * 100).toFixed(2) + "%", E = () => {
    d.value && (d.value.radioType = k.value, h.value === "costReport" ? g.value = true : d.value.visible = true);
  }, m = (o, t, a) => {
    f.value = false, h.value = o, N.value = t, k.value = a, E(), le(() => f.value = true);
  }, q = (o) => {
    o && E();
  };
  return X("tableItem", { projectInfo: N, mark: k }), j({ getSelfProjectList: y }), (o, t) => {
    const a = ne, R = oe, F = Y("common-table"), $ = se;
    return s(), r(ae, null, [_("div", ue, [Z((s(), v(F, { data: p.value, "max-height": x(A), border: "", fit: "" }, { default: n(() => [l(a, { align: "center", label: "序号", type: "index", width: "60" }), l(a, { align: "left", label: "项目", "min-width": "160", "show-overflow-tooltip": "" }, { default: n(({ row: { projectName: e } }) => [_("span", null, i(e), 1)]), _: 1 }), l(a, { align: "center", label: "立项日期", prop: "createTime", "min-width": "100" }), l(a, { align: "center", label: "销售负责人", prop: "salesLeaderName" }), l(a, { align: "center", label: "项目状态", prop: "settlementStatus" }, { default: n(({ row: e }) => [e.settlementStatus === 0 ? (s(), v(R, { key: 0, type: "danger" }, { default: n(() => t[1] || (t[1] = [B("未结算")])), _: 1, __: [1] })) : e.settlementStatus === 1 ? (s(), v(R, { key: 1, type: "success" }, { default: n(() => t[2] || (t[2] = [B("已结算")])), _: 1, __: [2] })) : u("", true)]), _: 1 }), l(a, { align: "center", label: "合同额", "min-width": "100", prop: "amount" }), l(a, { align: "center", label: "结算额", "min-width": "100", prop: "settlementAmount" }, { default: n(({ row: { settlementAmount: e } }) => [e ? (s(), r("span", pe, i(e), 1)) : u("", true)]), _: 1 }), l(a, { align: "center", label: "预结算额", "min-width": "100", prop: "preSettlementAmount" }, { default: n(({ row: e }) => [e.preSettlementAmount ? (s(), r("span", { key: 0, class: "specialText", onClick: (C) => m("record", e, "preSettle") }, i(e.preSettlementAmount), 9, de)) : u("", true)]), _: 1 }), l(a, { align: "center", label: "累计收款", "min-width": "100", prop: "accumulatedCollection" }, { default: n(({ row: e }) => [e.accumulatedCollection ? (s(), r("span", { key: 0, class: "specialText", onClick: (C) => m("record", e, "collection") }, i(e.accumulatedCollection), 9, me)) : u("", true)]), _: 1 }), l(a, { align: "center", label: "收款比例（%）", "min-width": "110", prop: "collectionRatio" }, { default: n(({ row: e }) => [_("span", null, i(D(e.collectionRatio)), 1)]), _: 1 }), l(a, { align: "center", label: "累计开票", "min-width": "100", prop: "accumulatedInvoice" }, { default: n(({ row: e }) => [e.accumulatedInvoice ? (s(), r("span", { key: 0, class: "specialText", onClick: (C) => m("record", e, "expend") }, i(e.accumulatedInvoice), 9, _e)) : u("", true)]), _: 1 }), l(a, { align: "center", label: "开票比例（%）", "min-width": "110", prop: "invoiceRatio" }, { default: n(({ row: e }) => [_("span", null, i(D(e.invoiceRatio)), 1)]), _: 1 }), l(a, { align: "center", label: "累计成本", "min-width": "100", prop: "accumulatedCost" }, { default: n(({ row: e }) => [e.accumulatedCost ? (s(), r("span", { key: 0, class: "specialText", onClick: (C) => m("costReport", e, "MATERIALS_COST") }, i(e.accumulatedCost), 9, ve)) : u("", true)]), _: 1 }), l(a, { align: "center", label: "可用余额", "min-width": "100", prop: "availableBalance" }, { default: n(({ row: e }) => [e.availableBalance !== "-" && e.availableBalance ? (s(), r("span", { key: 0, style: ee(e.availableBalance.startsWith("-") ? { color: "#FF0000" } : {}) }, i(e.availableBalance), 5)) : (s(), r("span", fe, "-"))]), _: 1 }), l(a, { align: "center", label: "合同（结算）应收", "min-width": "130", prop: "advancesReceived" }, { default: n(({ row: { advancesReceived: e } }) => [e ? (s(), r("span", be, i(e), 1)) : u("", true)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[$, b.value]]), l(W, { "request-data": x(T), total: x(S), onHandleChange: y }, null, 8, ["request-data", "total"])]), f.value ? (s(), v(te(M.value), { key: 0, ref_key: "currentComponentRef", ref: d, visible: g.value, "onUpdate:visible": t[0] || (t[0] = (e) => g.value = e), apikey: P.value, level: 1, onComponentMounted: q }, null, 40, ["visible", "apikey"])) : u("", true)], 64);
  };
} }, Se = H(ge, [["__scopeId", "data-v-b790366e"]]);
export {
  Se as default
};
