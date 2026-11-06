import { ref as m } from "vue";
import { computed as q } from "vue";
import { provide as D } from "vue";
import { resolveComponent as y } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as E } from "vue";
import { createElementVNode as A } from "vue";
import { createVNode as n } from "vue";
import { unref as e } from "vue";
import { withDirectives as I } from "vue";
import { createBlock as a } from "vue";
import { withCtx as b } from "vue";
import { createCommentVNode as l } from "vue";
import { ElTableColumn as R } from "element-plus";
import { vLoading as T } from "element-plus";
import { c as j } from "../../../../modules/logistics-record-ledger-a6792d58.js";
import { _ as B, t as L, x as M, uF as s, o as S, jE as u, G as v, P as U } from "../../../../shared/runtime.js";
import $ from "./module/header.vue.js";
import F from "./module/record-detail.vue.js";
const H = { class: "app-container" }, O = { class: "head-container" }, z = { __name: "index", setup(G) {
  const { decimalPrecision: g } = L(), w = { add: false, edit: false, del: false, download: false }, d = m(), c = m(false), _ = m({}), { crud: o, columns: r } = M({ title: "物流记录", sort: [], permission: { ...s }, optShow: { ...w }, crudApi: { ...j }, hasPagination: true }, d), x = q(() => [["freight", ["to-thousand", g.value.supplyChain]]]), { maxHeight: N } = S({ paginate: true });
  function k(f) {
    _.value = f, c.value = true;
  }
  return D("query", o.query), (f, h) => {
    const i = R, C = y("common-button"), V = y("common-table"), P = T;
    return t(), E("div", H, [A("div", O, [n(e($))]), I((t(), a(V, { ref_key: "tableRef", ref: d, data: e(o).data, "empty-text": e(o).emptyText, "max-height": e(N), "data-format": x.value, "return-source-data": "", showEmptySymbol: false, style: { width: "100%" } }, { default: b(() => [n(i, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), e(o).query.type === e(u).PRODUCT.V && e(r).visible("projectName") ? (t(), a(i, { key: "projectName", prop: "projectName", "show-overflow-tooltip": "", label: "所属项目", align: "center", "min-width": "140" })) : l("", true), e(o).query.type === e(u).MATERIAL.V && e(r).visible("serialNumber") ? (t(), a(i, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": "", label: "采购合同编号", align: "center", "min-width": "140" })) : l("", true), e(o).query.type === e(u).COMPANY.V && e(r).visible("supplierName") ? (t(), a(i, { key: "supplierName", prop: "supplierName", "show-overflow-tooltip": "", label: "物流公司", align: "center", "min-width": "140" })) : l("", true), e(r).visible("trainNumber") ? (t(), a(i, { key: "trainNumber", prop: "trainNumber", "show-overflow-tooltip": "", label: "累计使用车次/船次", align: "center", "min-width": "100" })) : l("", true), e(r).visible("freight") ? (t(), a(i, { key: "freight", prop: "freight", "show-overflow-tooltip": "", label: "累计运费", align: "right", "min-width": "100" })) : l("", true), e(v)([...e(s).detail]) ? (t(), a(i, { key: 5, label: "操作", width: "180", align: "center" }, { default: b((p) => [e(v)(e(s).detail) ? (t(), a(C, { key: 0, type: "primary", icon: "el-icon-view", size: "default", onClick: (Y) => k(p.row) }, null, 8, ["onClick"])) : l("", true)]), _: 1 })) : l("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "data-format"])), [[P, e(o).loading]]), n(e(U)), n(e(F), { modelValue: c.value, "onUpdate:modelValue": h[0] || (h[0] = (p) => c.value = p), detailInfo: _.value, permission: e(s), type: e(o).query.type }, null, 8, ["modelValue", "detailInfo", "permission", "type"])]);
  };
} }, Z = B(z, [["__scopeId", "data-v-00c4c641"]]);
export {
  Z as default
};
