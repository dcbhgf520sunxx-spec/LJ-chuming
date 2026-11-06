import { ref as v } from "vue";
import { resolveComponent as A } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as x } from "vue";
import { createElementVNode as i } from "vue";
import { createVNode as p } from "vue";
import { unref as t } from "vue";
import { withDirectives as k } from "vue";
import { createBlock as r } from "vue";
import { withCtx as o } from "vue";
import { toDisplayString as s } from "vue";
import { createCommentVNode as c } from "vue";
import { createTextVNode as N } from "vue";
import { ElTableColumn as T } from "element-plus";
import { ElTag as j } from "element-plus";
import { vLoading as D } from "element-plus";
import { l as C, _ as M, t as P, x as V, o as B, z as E, p as S, bN as H, bV as m, P as R } from "../../../shared/runtime.js";
import { a as W } from "../../../modules/contract-9b18cc88.js";
import L from "./module/header.vue.js";
function q(_) {
  return C({ module: "contract", url: "contract/collection/listCollectionWarning", method: "get", params: _ });
}
const z = { get: q };
const F = { class: "app-container" }, I = { class: "head-container" }, U = { __name: "index", setup(_) {
  const { decimalPrecision: u } = P(), f = { add: false, edit: false, del: false, download: false }, g = v(), { crud: d, columns: l } = V({ title: "收款预警", sort: [], permission: { ...W }, optShow: { ...f }, crudApi: { ...z }, hasPagination: true }, g), { maxHeight: w } = B({ wrapperBox: ".collectionWarn", paginate: true, extraHeight: 40 });
  return ($, G) => {
    const n = T, b = j, h = A("common-table"), y = D;
    return a(), x("div", F, [i("div", I, [p(t(L))]), k((a(), r(h, { ref_key: "tableRef", ref: g, data: t(d).data, "empty-text": t(d).emptyText, "max-height": t(w), style: { width: "100%" }, stripe: false, "return-source-data": "", showEmptySymbol: false }, { default: o(() => [p(n, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(l).visible("project") ? (a(), r(n, { key: "project.shortName", prop: "project", "show-overflow-tooltip": true, label: "项目", "min-width": "150" }, { default: o((e) => [i("span", null, s(t(E)(e.row.project)), 1)]), _: 1 })) : c("", true), t(l).visible("signingDate") ? (a(), r(n, { key: "signingDate", prop: "signingDate", label: "签约日期", align: "center" }, { default: o((e) => [i("div", null, s(e.row.signingDate ? t(S)(e.row.signingDate, "{y}-{m}-{d}") : "-"), 1)]), _: 1 })) : c("", true), t(l).visible("projectManagerName") ? (a(), r(n, { key: "projectManagerName", prop: "projectManagerName", "show-overflow-tooltip": true, label: "业务负责人", align: "center" }, { default: o((e) => [i("div", null, s(e.row.projectManagerName ? e.row.projectManagerName : "-"), 1)]), _: 1 })) : c("", true), t(l).visible("businessType") ? (a(), r(n, { key: "businessType", prop: "businessType", "show-overflow-tooltip": true, label: "业务类型", align: "center" }, { default: o((e) => [i("span", null, s(e.row.businessType ? t(H).VL[e.row.businessType] : "-"), 1)]), _: 1 })) : c("", true), t(l).visible("contractAmount") ? (a(), r(n, { key: "contractAmount", prop: "contractAmount", "show-overflow-tooltip": true, label: "合同金额(元)", align: "center" }, { default: o((e) => [i("span", null, s(e.row.contractAmount ? t(m)(e.row.contractAmount, t(u).contract) : ""), 1)]), _: 1 })) : c("", true), t(l).visible("collectionAmount") ? (a(), r(n, { key: "collectionAmount", prop: "collectionAmount", label: "收款额(元)", align: "center" }, { default: o((e) => [i("div", null, s(e.row.collectionAmount ? t(m)(e.row.collectionAmount, t(u).contract) : "-"), 1)]), _: 1 })) : c("", true), t(l).visible("happenedAmount") ? (a(), r(n, { key: "happenedAmount", prop: "happenedAmount", label: "发生额(元)", align: "center" }, { default: o((e) => [i("div", null, s(e.row.happenedAmount ? t(m)(e.row.happenedAmount, t(u).contract) : "-"), 1)]), _: 1 })) : c("", true), t(l).visible("arrearAmount") ? (a(), r(n, { key: "arrearAmount", prop: "arrearAmount", label: "欠款(元)", align: "center" }, { default: o((e) => [p(b, { class: "collection-tag", type: e.row.arrearAmount < 0 ? "warning" : "success", effect: "plain" }, { default: o(() => [N(s(e.row.arrearAmount && e.row.arrearAmount > 0 ? t(m)(e.row.arrearAmount, t(u).contract) : e.row.arrearAmount), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : c("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[y, t(d).loading]]), p(t(R))]);
  };
} }, X = M(U, [["__scopeId", "data-v-4095c04d"]]);
export {
  X as default
};
