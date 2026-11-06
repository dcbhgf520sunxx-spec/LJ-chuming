import { ref as b } from "vue";
import { resolveComponent as y } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as v } from "vue";
import { createVNode as r } from "vue";
import { unref as e } from "vue";
import { withDirectives as S } from "vue";
import { createBlock as i } from "vue";
import { withCtx as p } from "vue";
import { createElementVNode as m } from "vue";
import { createTextVNode as c } from "vue";
import { toDisplayString as d } from "vue";
import { createCommentVNode as o } from "vue";
import { Fragment as D } from "vue";
import { renderList as P } from "vue";
import { ElTableColumn as A } from "element-plus";
import { ElImage as B } from "element-plus";
import { ElTag as V } from "element-plus";
import { vLoading as j } from "element-plus";
import { _ as H, uv as I, x as F, Bz as K, xk as L, BA as O, o as z, aR as M, k0 as x, an as $, P as G } from "../../../../shared/runtime.js";
import J from "./module/header.vue.js";
import Q from "./module/detail.vue.js";
const W = { class: "app-container" }, X = { class: "imgs-box" }, Y = { __name: "index", setup(Z) {
  const k = { add: false, edit: false, del: false, download: false }, w = b([]), _ = b(), T = b([...I, ["qualityTestingTime", "parse-time"], ["approvalComments", "empty-text"]]), { crud: h, columns: s, CRUD: N } = F({ title: "入库质检记录", sort: ["id.desc"], invisibleColumns: ["editorName", "userUpdateTime", "licensePlate", "shipmentNumber"], permission: { ...K }, optShow: { ...k }, crudApi: { ...L, detail: O } }, _), { maxHeight: C } = z({ paginate: true });
  return N.HOOK.handleRefresh = async (q, { data: n }) => {
    n.content = n.content.map((t) => {
      var u;
      return t.imgUrls = ((u = t.attachments) == null ? void 0 : u.map((f) => f.imageUrl)) || [], t;
    });
  }, (q, n) => {
    const t = A, u = y("table-cell-tag"), f = B, E = V, U = y("common-table"), R = j;
    return a(), v("div", W, [r(e(J)), S((a(), i(U, { ref_key: "tableRef", ref: _, data: e(h).data, "data-format": T.value, "max-height": e(C), "default-expand-all": false, "expand-row-keys": w.value, "row-key": "id" }, { default: p(() => [r(M, { data: e(h).data, "expand-row-keys": w.value, "onUpdate:expandRowKeys": n[0] || (n[0] = (l) => w.value = l), "row-key": "id" }, { default: p(({ row: l }) => [m("p", null, [n[1] || (n[1] = c(" 关联项目：")), m("span", null, d(l.projectsFullName), 1)]), m("p", null, [n[2] || (n[2] = c(" 质检备注：")), m("span", null, d(l.approvalComments), 1)])]), _: 1 }, 8, ["data", "expand-row-keys"]), r(t, { label: "序号", type: "index", align: "center", width: "60" }), e(s).visible("createTime") ? (a(), i(t, { key: "createTime", "show-overflow-tooltip": true, prop: "createTime", label: "申请时间", align: "center", width: "140" })) : o("", true), e(s).visible("applicantName") ? (a(), i(t, { key: "applicantName", "show-overflow-tooltip": true, prop: "applicantName", label: "申请人", align: "center", "min-width": "100" })) : o("", true), e(s).visible("purchaseSN") ? (a(), i(t, { key: "purchaseSN", "show-overflow-tooltip": true, prop: "purchaseSN", label: "采购单号", "min-width": "155" }, { default: p(({ row: l }) => [r(u, { show: !!l.boolPartyA, name: "甲供", type: "partyA", offset: 10 }, null, 8, ["show"]), c(" " + d(l.purchaseSN), 1)]), _: 1 })) : o("", true), e(s).visible("serialNumber") ? (a(), i(t, { key: "serialNumber", "show-overflow-tooltip": true, prop: "serialNumber", "min-width": "160", label: "入库单号", align: "left" })) : o("", true), e(s).visible("licensePlate") ? (a(), i(t, { key: "licensePlate", "show-overflow-tooltip": true, prop: "licensePlate", label: "车牌/船牌号", align: "left", width: "100" })) : o("", true), e(s).visible("shipmentNumber") ? (a(), i(t, { key: "shipmentNumber", prop: "shipmentNumber", label: "物流单号", align: "left", "min-width": "150", "show-overflow-tooltip": "" })) : o("", true), e(s).visible("basicClass") ? (a(), i(t, { key: "basicClass", "show-overflow-tooltip": true, prop: "basicClass", label: "物料种类", width: "120" })) : o("", true), e(s).visible("projects") ? (a(), i(t, { "show-overflow-tooltip": "", key: "projects", prop: "projects", label: "关联项目", "min-width": "170" })) : o("", true), e(s).visible("supplier.name") ? (a(), i(t, { key: "supplier.name", "show-overflow-tooltip": true, prop: "supplier.name", label: "供应商", "min-width": "200" })) : o("", true), e(s).visible("attachments") ? (a(), i(t, { key: "attachments", prop: "attachments", "show-overflow-tooltip": false, label: "质检图片", width: "150px", align: "left" }, { default: p(({ row: { sourceRow: l } }) => [m("div", X, [(a(true), v(D, null, P(l.attachments, (g) => (a(), i(f, { "preview-src-list": l.imgUrls, "initial-index": 1, key: g.id, src: g.tinyImageUrl, lazy: "" }, null, 8, ["preview-src-list", "src"]))), 128))])]), _: 1 })) : o("", true), e(s).visible("qualityTestingUserName") ? (a(), i(t, { key: "qualityTestingUserName", "show-overflow-tooltip": true, prop: "qualityTestingUserName", label: "质检人", align: "center", "min-width": "100" })) : o("", true), e(s).visible("qualityTestingTime") ? (a(), i(t, { key: "qualityTestingTime", "show-overflow-tooltip": true, prop: "qualityTestingTime", label: "质检时间", align: "center", width: "140" })) : o("", true), e(s).visible("qualityTestingEnum") ? (a(), i(t, { key: "qualityTestingEnum", "show-overflow-tooltip": true, prop: "qualityTestingEnum", label: "质检状态", align: "center", width: "100", fixed: "right" }, { default: p(({ row: l }) => [r(E, { type: e(x).V[l.qualityTestingEnum].TAG }, { default: p(() => [c(d(e(x).V[l.qualityTestingEnum].SL), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : o("", true), r(t, { label: "操作", width: "90px", align: "center", fixed: "right" }, { default: p(({ row: l }) => [r($, { data: l, "show-detail": "", showDel: false, showEdit: false }, null, 8, ["data"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height", "expand-row-keys"])), [[R, e(h).loading]]), r(e(G)), r(Q)]);
  };
} }, ie = H(Y, [["__scopeId", "data-v-eb360ce4"]]);
export {
  ie as default
};
