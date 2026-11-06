import { computed as U } from "vue";
import { ref as A } from "vue";
import { resolveComponent as V } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as _ } from "vue";
import { createElementVNode as o } from "vue";
import { createVNode as w } from "vue";
import { unref as a } from "vue";
import { withDirectives as j } from "vue";
import { createBlock as r } from "vue";
import { withCtx as n } from "vue";
import { toDisplayString as c } from "vue";
import { createCommentVNode as s } from "vue";
import { Fragment as v } from "vue";
import { renderList as S } from "vue";
import { createTextVNode as D } from "vue";
import { ElTableColumn as C } from "element-plus";
import { ElImage as I } from "element-plus";
import { ElTag as E } from "element-plus";
import { vLoading as H } from "element-plus";
import { l as P, _ as B, t as z, x as F, o as K, y as k, z as Q, A as b, P as M } from "../../../../shared/runtime.js";
import { b as Y } from "../../../../modules/bridge-86f96a4f.js";
import $ from "./module/header.vue.js";
function G(g) {
  return P({ module: "bridge", url: "qhse/page", method: "get", params: g });
}
const J = { get: G };
const W = { class: "app-container" }, X = { class: "head-container" }, Z = { style: { "white-space": "pre-line" } }, ee = { class: "project-name" }, te = { class: "imgs-box" }, ae = { class: "imgs-box" }, ie = { style: { "white-space": "pre-line" } }, re = { __name: "index", setup(g) {
  const { decimalPrecision: O } = z(), N = { add: false, edit: false, del: false, download: false }, q = U(() => [["createTime", "parse-time"], ["rectifyTime", "parse-time"], ["forfeit", ["to-fixed", O.value.bridge]]]), T = A(), { crud: p, columns: l, CRUD: x } = F({ title: "问题曝光", invisibleColumns: [], permission: { ...Y }, optShow: { ...N }, crudApi: { ...J } }, T), { maxHeight: R } = K({ paginate: true });
  return x.HOOK.beforeToQuery = () => {
    p.query.type !== k.QUALITY.V && (p.query.projectId = void 0);
  }, x.HOOK.handleRefresh = (L, m) => {
    m.data.content = m.data.content.map((e) => {
      var u, y, h;
      return e.qualityTypeListStr = e.qualityTypeList && e.qualityTypeList.join("、"), e.imgUrls = e.attachmentDTOS && e.attachmentDTOS.map((d) => d.imageUrl), e.qhseRectifyDTOS && e.qhseRectifyDTOS.length && (e.rectifyName = (u = e.qhseRectifyDTOS[0]) == null ? void 0 : u.name, e.rectifyTime = (y = e.qhseRectifyDTOS[0]) == null ? void 0 : y.createTime, e.rectifyAttachmentDTOS = (h = e.qhseRectifyDTOS[0]) == null ? void 0 : h.attachmentDTOS, e.rectifyImgUrls = e.rectifyAttachmentDTOS && e.rectifyAttachmentDTOS.map((d) => d.imageUrl)), e;
    });
  }, (L, m) => {
    const e = C, u = I, y = E, h = V("common-table"), d = H;
    return i(), _("div", W, [o("div", X, [w(a($))]), j((i(), r(h, { ref_key: "tableRef", ref: T, data: a(p).data, "data-format": q.value, "empty-text": a(p).emptyText, "max-height": a(R), style: { width: "100%" } }, { default: n(() => [w(e, { label: "序号", type: "index", align: "center", width: "60" }), a(l).visible("type") ? (i(), r(e, { key: 0, "show-overflow-tooltip": true, prop: "type", label: "问题类型", align: "center", width: "100px" }, { default: n(({ row: { sourceRow: t } }) => [o("span", null, c(a(k).VL[t.type]), 1)]), _: 1 })) : s("", true), a(l).visible("userName") ? (i(), r(e, { key: 1, "show-overflow-tooltip": true, prop: "userName", label: "发起人", align: "center", width: "140px" }, { default: n(({ row: t }) => [o("span", Z, [o("span", null, c(t.userName + `
`), 1), o("span", null, c(t.createTime), 1)])]), _: 1 })) : s("", true), a(l).visible("project.shortName") ? (i(), r(e, { key: 2, prop: "project.shortName", "show-overflow-tooltip": true, label: "所属项目", "min-width": "250" }, { default: n(({ row: { sourceRow: t } }) => [o("span", ee, c(a(Q)(t.project)), 1)]), _: 1 })) : s("", true), a(l).visible("qualityTypeListStr") ? (i(), r(e, { key: 3, "show-overflow-tooltip": true, prop: "qualityTypeListStr", label: "问题", "min-width": "100px" }, { default: n(({ row: t }) => [o("span", null, c(t.qualityTypeListStr), 1)]), _: 1 })) : s("", true), a(l).visible("remark") ? (i(), r(e, { key: "remark", prop: "remark", "show-overflow-tooltip": true, label: "描述", "min-width": "200px" })) : s("", true), a(l).visible("dutyName") ? (i(), r(e, { key: "dutyName", prop: "dutyName", "show-overflow-tooltip": true, label: "责任人", "min-width": "100px", align: "center" })) : s("", true), a(l).visible("attachmentDTOS") ? (i(), r(e, { key: "attachmentDTOS", prop: "attachmentDTOS", "show-overflow-tooltip": false, label: "问题图片", width: "150px", align: "left" }, { default: n(({ row: { sourceRow: t } }) => [o("div", te, [(i(true), _(v, null, S(t.attachmentDTOS, (f) => (i(), r(u, { "preview-src-list": t.imgUrls, "initial-index": 1, key: f.id, src: f.tinyImageUrl, "scroll-container": ".el-table__body-wrapper", "preview-teleported": "", lazy: "" }, null, 8, ["preview-src-list", "src"]))), 128))])]), _: 1 })) : s("", true), a(l).visible("status") ? (i(), r(e, { key: "status", prop: "status", "show-overflow-tooltip": true, label: "状态", "min-width": "80px", align: "center" }, { default: n(({ row: { sourceRow: t } }) => [a(b).VK[t.status] ? (i(), r(y, { key: 0, type: a(b).V[t.status].T }, { default: n(() => [D(c(a(b).VL[t.status]), 1)]), _: 2 }, 1032, ["type"])) : s("", true)]), _: 1 })) : s("", true), a(l).visible("rectifyAttachmentDTOS") ? (i(), r(e, { key: 8, prop: "rectifyAttachmentDTOS", "show-overflow-tooltip": false, label: "整改图片", width: "150px", align: "left" }, { default: n(({ row: { sourceRow: t } }) => [o("div", ae, [(i(true), _(v, null, S(t.rectifyAttachmentDTOS, (f) => (i(), r(u, { "preview-src-list": t.rectifyImgUrls, "initial-index": 1, key: f.id, src: f.tinyImageUrl, "scroll-container": ".el-table__body-wrapper", "preview-teleported": "", lazy: "" }, null, 8, ["preview-src-list", "src"]))), 128))])]), _: 1 })) : s("", true), a(l).visible("rectifyName") ? (i(), r(e, { key: 9, "show-overflow-tooltip": true, prop: "rectifyName", label: "整改人", align: "center", width: "140px" }, { default: n(({ row: t }) => [o("span", ie, [o("span", null, c(t.rectifyName), 1), m[0] || (m[0] = D(c(`
`) + " ")), o("span", null, c(t.rectifyTime), 1)])]), _: 1 })) : s("", true), a(l).visible("forfeit") ? (i(), r(e, { key: 10, "show-overflow-tooltip": true, prop: "forfeit", label: "罚金(元)", align: "center" }, { default: n(({ row: t }) => [o("span", null, c(t.forfeit), 1)]), _: 1 })) : s("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[d, a(p).loading]]), w(a(M))]);
  };
} }, ce = B(re, [["__scopeId", "data-v-b006ab05"]]);
export {
  ce as default
};
