import { ref as x } from "vue";
import { resolveComponent as Y } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as O } from "vue";
import { createVNode as l } from "vue";
import { unref as t } from "vue";
import { withDirectives as R } from "vue";
import { createBlock as o } from "vue";
import { withCtx as n } from "vue";
import { createCommentVNode as i } from "vue";
import { createElementVNode as B } from "vue";
import { toDisplayString as p } from "vue";
import { createTextVNode as S } from "vue";
import { ElTableColumn as H } from "element-plus";
import { ElTag as U } from "element-plus";
import { vLoading as L } from "element-plus";
import { _ as P, o as M, x as F, us as h, ut as K, D as _, bv as E, cP as N, uu as d, c7 as j, p as T, iF as m, G as J, an as q, P as G } from "../../../shared/runtime.js";
import I from "./component/form.vue.js";
import z from "./component/header.vue.js";
import "../../../modules/UploadBtn-b4cfb47a.js";
const Q = { class: "app-container" }, W = { __name: "index", setup(X) {
  const { maxHeight: C } = M({ wrapperBox: [".app-container", "#production-line-content"], extraBox: [".head-container", ".div__header"], paginate: true, extraHeight: 55 }), k = { add: true, edit: false, del: false, download: false }, g = x(), { crud: f, columns: r, CRUD: b } = F({ title: "年度合同", sort: [], permission: { ...h }, optShow: { ...k }, crudApi: { ...K }, invisibleColumns: [] }, g), v = x([["createTime", "parse-time"], ["amount", ["to-thousand", _.YUAN]], ["thisYearAmount", ["to-thousand", _.YUAN]], ["lastYearAmount", ["to-thousand", _.YUAN]]]);
  return b.HOOK.handleRefresh = (A, { data: w }) => {
    w.content.map((e) => {
      const c = E.getBits(N.ENUM, e.basicClass, "L");
      e.basicClassArr = E.getBits(N.ENUM, e.basicClass, "V"), e.originBasicClassArr = JSON.parse(JSON.stringify(e.basicClassArr)), e.basicClassStr = c.join(","), e.effectStatus = e.timeEnd > (/* @__PURE__ */ new Date()).getTime() ? d.YES.V : d.NO.V, e.days = e.timeEnd > (/* @__PURE__ */ new Date()).getTime() ? j((/* @__PURE__ */ new Date()).getTime(), e.timeEnd) : void 0, e.date = e.timeStart && e.timeEnd ? [e.timeStart, e.timeEnd] : [], e.status = e.status ? 1 : 0;
    });
  }, b.HOOK.afterSubmit = () => {
  }, b.HOOK.afterDelete = () => {
  }, (A, w) => {
    const e = H, c = U, D = Y("common-table"), V = L;
    return a(), O("div", Q, [l(t(z), { ref: "headerRef" }, null, 512), R((a(), o(D, { ref_key: "tableRef", ref: g, data: t(f).data, "data-format": v.value, "default-expand-all": false, "empty-text": t(f).emptyText, "max-height": t(C), "highlight-current-row": "", style: { width: "100%" } }, { default: n(() => [l(e, { align: "center", label: "序号", type: "index", width: "60" }), t(r).visible("createTime") ? (a(), o(e, { key: "createTime", "show-overflow-tooltip": true, align: "center", label: "创建时间", prop: "createTime" })) : i("", true), t(r).visible("applicantName") ? (a(), o(e, { key: "applicantName", "show-overflow-tooltip": true, align: "center", label: "创建人", prop: "applicantName" })) : i("", true), t(r).visible("serialNumber") ? (a(), o(e, { key: "serialNumber", "show-overflow-tooltip": true, align: "center", label: "合同编号", prop: "serialNumber" })) : i("", true), t(r).visible("supplierName") ? (a(), o(e, { key: "supplierName", "show-overflow-tooltip": true, align: "center", label: "供应商", prop: "supplierName" })) : i("", true), t(r).visible("basicClassStr") ? (a(), o(e, { key: "basicClassStr", "show-overflow-tooltip": true, align: "center", label: "物料类型", prop: "basicClassStr" })) : i("", true), t(r).visible("updateTimes") ? (a(), o(e, { key: "updateTimes", "show-overflow-tooltip": true, align: "center", label: "有效期", prop: "updateTimes", "min-width": "150" }, { default: n(({ row: { sourceRow: s } }) => [B("span", null, p(s.timeStart ? t(T)(s.timeStart, "{y}-{m}-{d}") : "-") + "~" + p(s.timeEnd ? t(T)(s.timeEnd, "{y}-{m}-{d}") : "-"), 1)]), _: 1 })) : i("", true), t(r).visible("days") ? (a(), o(e, { key: "days", "show-overflow-tooltip": true, align: "center", label: "有效时间", prop: "days" })) : i("", true), t(r).visible("effectStatus") ? (a(), o(e, { key: "effectStatus", "show-overflow-tooltip": true, align: "center", label: "状态", prop: "effectStatus" }, { default: n(({ row: { sourceRow: s } }) => {
      var u, y;
      return [l(c, { type: (y = (u = t(d)) == null ? void 0 : u.V[s.effectStatus]) == null ? void 0 : y.T }, { default: n(() => [S(p(t(d).VL[s.effectStatus]), 1)]), _: 2 }, 1032, ["type"])];
    }), _: 1 })) : i("", true), t(r).visible("status") ? (a(), o(e, { key: "status", "show-overflow-tooltip": true, align: "center", label: "结算状态", prop: "status" }, { default: n(({ row: { sourceRow: s } }) => {
      var u;
      return [l(c, { type: (u = t(m).V[s.status]) == null ? void 0 : u.T }, { default: n(() => [S(p(t(m).VL[s.status]), 1)]), _: 2 }, 1032, ["type"])];
    }), _: 1 })) : i("", true), t(r).visible("amount") ? (a(), o(e, { key: "amount", "show-overflow-tooltip": true, align: "center", label: "累计交易额", prop: "amount" })) : i("", true), t(r).visible("lastYearAmount") ? (a(), o(e, { key: "lastYearAmount", "show-overflow-tooltip": true, align: "center", label: "上年度交易额", prop: "lastYearAmount" })) : i("", true), t(r).visible("thisYearAmount") ? (a(), o(e, { key: "thisYearAmount", "show-overflow-tooltip": true, align: "center", label: "本年度交易额", prop: "thisYearAmount" })) : i("", true), t(J)([...t(h).edit, ...t(h).del]) ? (a(), o(e, { key: 12, align: "center", fixed: "right", label: "操作", width: "130px" }, { default: n(({ row: { sourceRow: s } }) => [l(t(q), { data: s, "disabled-del": s.status === t(m).SETTLED.V, "disable-edit": s.status === t(m).SETTLED.V }, null, 8, ["data", "disabled-del", "disable-edit"])]), _: 1 })) : i("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[V, t(f).loading]]), l(t(G)), l(t(I))]);
  };
} }, se = P(W, [["__scopeId", "data-v-631a0bc6"]]);
export {
  se as default
};
