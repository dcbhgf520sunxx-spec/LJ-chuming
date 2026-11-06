import { inject as C } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as n } from "vue";
import { createElementVNode as s } from "vue";
import { Fragment as u } from "vue";
import { renderList as L } from "vue";
import { createBlock as x } from "vue";
import { withCtx as h } from "vue";
import { toDisplayString as _ } from "vue";
import { createVNode as l } from "vue";
import { unref as o } from "vue";
import { createCommentVNode as d } from "vue";
import { normalizeStyle as I } from "vue";
import { ElCard as w } from "element-plus";
import { _ as k, a as A, b as S } from "../../../../../../modules/assemble-change-set-01d99287.js";
import { _ as N, a as H } from "../../../../../../modules/machine-part-change-table-207fbedf.js";
import { _ as O, nd as $ } from "../../../../../../shared/runtime.js";
import "../../../../../../modules/common-ac6e385c.js";
const B = { class: "left-con" }, V = { class: "index" }, D = { class: "new-sn" }, E = { class: "old-sn" }, T = { class: "right-btn" }, j = { class: "box-content" }, z = { style: { display: "flex" } }, F = { key: 0, class: "box-content" }, q = { key: 1, class: "box-content" }, G = { key: 2, class: "box-content" }, J = { __name: "handle", props: { heightStyle: { type: String } }, setup(g) {
  const v = C("changeInfo");
  return (K, a) => {
    const y = w;
    return t(), n("div", { class: "handle-content", style: I(g.heightStyle) }, [s("div", B, [(t(true), n(u, null, L(o(v), (e, f) => (t(), x(y, { key: f, class: "artifact-content" }, { header: h(() => {
      var r, i;
      return [s("div", V, _(f + 1), 1), s("span", D, _((r = e.newArtifact) == null ? void 0 : r.serialNumber), 1), s("span", E, "原构件编号：" + _((i = e.oldArtifact) == null ? void 0 : i.serialNumber), 1), s("span", T, [l($, { "is-active": e.foldOpened, class: "hamburger-container", onToggleClick: (c) => e.foldOpened = !e.foldOpened }, null, 8, ["is-active", "onToggleClick"])])];
    }), default: h(() => {
      var r, i, c, p, m, b;
      return [e.foldOpened ? (t(), n(u, { key: 0 }, [s("div", j, [a[0] || (a[0] = s("div", { class: "handle-title" }, [s("span", null, "# 基本信息")], -1)), s("div", z, [l(o(k), { newArtifact: e.newArtifact, oldArtifact: e.oldArtifact, style: { width: "750px" } }, null, 8, ["newArtifact", "oldArtifact"]), l(o(A), { areaList: e.areaList, style: { flex: "1", "margin-left": "15px" } }, null, 8, ["areaList"])])]), (i = (r = e.assembleInfo) == null ? void 0 : r.needHandleNewList) != null && i.length ? (t(), n("div", F, [a[1] || (a[1] = s("div", { class: "handle-title" }, [s("span", null, "# 部件变更设置（单构件）")], -1)), l(o(S), { "new-assemble-list": ((c = e.assembleInfo) == null ? void 0 : c.needHandleNewList) || [], "old-assemble-list": ((p = e.assembleInfo) == null ? void 0 : p.needHandleOldList) || [], assembleInfo: e.assembleInfo }, null, 8, ["new-assemble-list", "old-assemble-list", "assembleInfo"])])) : d("", true), (m = e.assembleCompareList) != null && m.length ? (t(), n("div", q, [a[2] || (a[2] = s("div", { class: "handle-title" }, [s("span", null, "# 部件变更信息")], -1)), l(o(N), { assembleCompareList: e.assembleCompareList, assembleInfo: e.assembleInfo }, null, 8, ["assembleCompareList", "assembleInfo"])])) : d("", true), (b = e.partCompareList) != null && b.length ? (t(), n("div", G, [a[3] || (a[3] = s("div", { class: "handle-title" }, [s("span", null, "# 零件变更信息")], -1)), l(o(H), { partCompareList: e.partCompareList }, null, 8, ["partCompareList"])])) : d("", true)], 64)) : d("", true)];
    }), _: 2 }, 1024))), 128))])], 4);
  };
} }, W = O(J, [["__scopeId", "data-v-7568fcaa"]]);
export {
  W as default
};
