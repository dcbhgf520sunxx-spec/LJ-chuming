import { ref as w } from "vue";
import { resolveComponent as V } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as T } from "vue";
import { createElementVNode as o } from "vue";
import { createVNode as b } from "vue";
import { unref as a } from "vue";
import { withDirectives as C } from "vue";
import { createBlock as l } from "vue";
import { withCtx as n } from "vue";
import { toDisplayString as p } from "vue";
import { createCommentVNode as r } from "vue";
import { Fragment as k } from "vue";
import { renderList as O } from "vue";
import { createTextVNode as N } from "vue";
import { ElTableColumn as j } from "element-plus";
import { ElImage as I } from "element-plus";
import { ElTag as E } from "element-plus";
import { vLoading as H } from "element-plus";
import { c as B } from "../../../../modules/index-cfd8d896.js";
import { _ as z, x as F, mG as K, o as P, y as R, z as M, A as v, P as Q } from "../../../../shared/runtime.js";
import Y from "./module/header.vue.js";
import G from "./module/detail.vue.js";
const $ = { class: "app-container" }, J = { class: "head-container" }, W = { style: { "white-space": "pre-line" } }, X = { class: "project-name" }, Z = { class: "imgs-box" }, ee = { class: "imgs-box" }, te = { style: { "white-space": "pre-line" } }, ae = { __name: "index", setup(ie) {
  const q = { add: false, edit: false, del: false, download: false }, U = w([["createTime", "parse-time"], ["rectifyTime", "parse-time"], ["forfeit", ["to-fixed-ck", "YUAN"]]]), x = w(), D = w({}), g = w(false), { crud: m, columns: s, CRUD: S } = F({ title: "问题曝光", invisibleColumns: [], permission: { ...K }, optShow: { ...q }, crudApi: { ...B } }, x), { maxHeight: A } = P({ paginate: true });
  S.HOOK.beforeToQuery = () => {
    m.query.type !== R.QUALITY.V && (m.query.projectId = void 0);
  }, S.HOOK.handleRefresh = (y, c) => {
    c.data.content = c.data.content.map((e) => {
      var u, h, _;
      return e.qualityTypeListStr = e.qualityTypeList && e.qualityTypeList.join("、"), e.imgUrls = e.attachmentDTOS && e.attachmentDTOS.map((d) => d.imageUrl), e.qhseRectifyDTOS && e.qhseRectifyDTOS.length && (e.rectifyName = (u = e.qhseRectifyDTOS[0]) == null ? void 0 : u.name, e.rectifyTime = (h = e.qhseRectifyDTOS[0]) == null ? void 0 : h.createTime, e.rectifyAttachmentDTOS = (_ = e.qhseRectifyDTOS[0]) == null ? void 0 : _.attachmentDTOS, e.rectifyImgUrls = e.rectifyAttachmentDTOS && e.rectifyAttachmentDTOS.map((d) => d.imageUrl)), e;
    });
  };
  function L(y) {
    console.log(y, "val"), g.value = true, D.value = y;
  }
  return (y, c) => {
    const e = j, u = I, h = E, _ = V("common-table"), d = H;
    return i(), T("div", $, [o("div", J, [b(a(Y))]), C((i(), l(_, { ref_key: "tableRef", ref: x, data: a(m).data, "data-format": U.value, "empty-text": a(m).emptyText, "max-height": a(A), "show-empty-symbol": false, style: { width: "100%" }, onRowDblclick: L }, { default: n(() => [b(e, { label: "序号", type: "index", align: "center", width: "60" }), a(s).visible("type") ? (i(), l(e, { key: 0, "show-overflow-tooltip": true, prop: "type", label: "问题类型", align: "center", width: "100px" }, { default: n(({ row: { sourceRow: t } }) => [o("span", null, p(a(R).VL[t.type]), 1)]), _: 1 })) : r("", true), a(s).visible("serialNumber") ? (i(), l(e, { key: 1, "show-overflow-tooltip": true, prop: "serialNumber", label: "构件编号", align: "center", width: "100px" }, { default: n(({ row: t }) => [o("span", null, p(t.serialNumber || "/"), 1)]), _: 1 })) : r("", true), a(s).visible("userName") ? (i(), l(e, { key: 2, "show-overflow-tooltip": true, prop: "userName", label: "发起人", align: "center", width: "140px" }, { default: n(({ row: t }) => [o("span", W, [o("span", null, p(t.userName + `
`), 1), o("span", null, p(t.createTime), 1)])]), _: 1 })) : r("", true), a(s).visible("project.shortName") ? (i(), l(e, { key: 3, prop: "project.shortName", "show-overflow-tooltip": true, label: "所属项目", "min-width": "250" }, { default: n(({ row: { sourceRow: t } }) => [o("span", X, p(a(M)(t.project)), 1)]), _: 1 })) : r("", true), a(s).visible("qualityTypeListStr") ? (i(), l(e, { key: 4, "show-overflow-tooltip": true, prop: "qualityTypeListStr", label: "问题", "min-width": "100px" }, { default: n(({ row: t }) => [o("span", null, p(t.qualityTypeListStr), 1)]), _: 1 })) : r("", true), a(s).visible("remark") ? (i(), l(e, { key: "remark", prop: "remark", "show-overflow-tooltip": true, label: "描述", "min-width": "200px" })) : r("", true), a(s).visible("dutyName") ? (i(), l(e, { key: "dutyName", prop: "dutyName", "show-overflow-tooltip": true, label: "责任人", "min-width": "100px", align: "center" })) : r("", true), a(s).visible("attachmentDTOS") ? (i(), l(e, { key: "attachmentDTOS", prop: "attachmentDTOS", "show-overflow-tooltip": false, label: "问题图片", width: "150px", align: "left" }, { default: n(({ row: { sourceRow: t } }) => [o("div", Z, [(i(true), T(k, null, O(t.attachmentDTOS, (f) => (i(), l(u, { "preview-src-list": t.imgUrls, "initial-index": 1, key: f.id, src: f.tinyImageUrl, "scroll-container": ".el-table__body-wrapper", "preview-teleported": "", lazy: "" }, null, 8, ["preview-src-list", "src"]))), 128))])]), _: 1 })) : r("", true), a(s).visible("status") ? (i(), l(e, { key: "status", prop: "status", "show-overflow-tooltip": true, label: "状态", "min-width": "85px", align: "center" }, { default: n(({ row: { sourceRow: t } }) => [a(v).VK[t.status] ? (i(), l(h, { key: 0, type: a(v).V[t.status].T }, { default: n(() => [N(p(a(v).VL[t.status]), 1)]), _: 2 }, 1032, ["type"])) : r("", true)]), _: 1 })) : r("", true), a(s).visible("rectifyAttachmentDTOS") ? (i(), l(e, { key: 9, prop: "rectifyAttachmentDTOS", "show-overflow-tooltip": false, label: "整改图片", width: "150px", align: "left" }, { default: n(({ row: { sourceRow: t } }) => [o("div", ee, [(i(true), T(k, null, O(t.rectifyAttachmentDTOS, (f) => (i(), l(u, { "preview-src-list": t.rectifyImgUrls, "initial-index": 1, key: f.id, src: f.tinyImageUrl, "scroll-container": ".el-table__body-wrapper", "preview-teleported": "", lazy: "" }, null, 8, ["preview-src-list", "src"]))), 128))])]), _: 1 })) : r("", true), a(s).visible("rectifyName") ? (i(), l(e, { key: 10, "show-overflow-tooltip": true, prop: "rectifyName", label: "整改人", align: "center", width: "140px" }, { default: n(({ row: t }) => [o("span", te, [o("span", null, p(t.rectifyName), 1), c[1] || (c[1] = N(p(`
`) + " ")), o("span", null, p(t.rectifyTime), 1)])]), _: 1 })) : r("", true), a(s).visible("forfeit") ? (i(), l(e, { key: 11, "show-overflow-tooltip": true, prop: "forfeit", label: "罚金(元)", align: "center" }, { default: n(({ row: t }) => [o("span", null, p(t.forfeit), 1)]), _: 1 })) : r("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[d, a(m).loading]]), b(a(Q)), b(G, { visible: g.value, "onUpdate:visible": c[0] || (c[0] = (t) => g.value = t), "detail-data": D.value }, null, 8, ["visible", "detail-data"])]);
  };
} }, pe = z(ae, [["__scopeId", "data-v-846b7de7"]]);
export {
  pe as default
};
