import { inject as C } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as n } from "vue";
import { createElementVNode as s } from "vue";
import { Fragment as h } from "vue";
import { renderList as I } from "vue";
import { createBlock as x } from "vue";
import { withCtx as g } from "vue";
import { toDisplayString as f } from "vue";
import { createVNode as l } from "vue";
import { unref as o } from "vue";
import { createCommentVNode as r } from "vue";
import { normalizeStyle as w } from "vue";
import { ElCard as k } from "element-plus";
import { _ as A, a as S, b as N } from "../../../../../../modules/assemble-change-set-01d99287.js";
import { _ as H, a as O } from "../../../../../../modules/machine-part-change-table-207fbedf.js";
import { _ as $, nd as B } from "../../../../../../shared/runtime.js";
import "../../../../../../modules/common-ac6e385c.js";
const V = { class: "left-con" }, D = { class: "index" }, E = { class: "new-sn" }, T = { class: "old-sn" }, j = { class: "right-btn" }, z = { class: "box-content" }, F = { style: { display: "flex" } }, q = { key: 0, class: "box-content" }, G = { key: 1, class: "box-content" }, J = { key: 2, class: "box-content" }, K = { __name: "handle-info", props: { heightStyle: { type: String } }, setup(v) {
  const y = C("changeInfo");
  return (M, a) => {
    var _;
    const L = k;
    return t(), n("div", { class: "handle-content", style: w(v.heightStyle) }, [s("div", V, [(t(true), n(h, null, I((_ = o(y)) == null ? void 0 : _.changeList, (e, p) => (t(), x(L, { key: p, class: "artifact-content" }, { header: g(() => {
      var d, i;
      return [s("div", D, f(p + 1), 1), s("span", E, f((d = e.newArtifact) == null ? void 0 : d.serialNumber), 1), s("span", T, "原构件编号：" + f((i = e.oldArtifact) == null ? void 0 : i.serialNumber), 1), s("span", j, [l(B, { "is-active": e.foldOpened, class: "hamburger-container", onToggleClick: (c) => e.foldOpened = !e.foldOpened }, null, 8, ["is-active", "onToggleClick"])])];
    }), default: g(() => {
      var d, i, c, m, b, u;
      return [e.foldOpened ? (t(), n(h, { key: 0 }, [s("div", z, [a[0] || (a[0] = s("div", { class: "handle-title" }, [s("span", null, "# 基本信息")], -1)), s("div", F, [l(o(A), { newArtifact: e.newArtifact, oldArtifact: e.oldArtifact, style: { width: "750px" } }, null, 8, ["newArtifact", "oldArtifact"]), l(o(S), { areaList: e.areaList, style: { flex: "1", "margin-left": "15px" } }, null, 8, ["areaList"])])]), (i = (d = e.assembleInfo) == null ? void 0 : d.needHandleNewList) != null && i.length ? (t(), n("div", q, [a[1] || (a[1] = s("div", { class: "handle-title" }, [s("span", null, "# 部件变更设置（单构件）")], -1)), l(o(N), { "new-assemble-list": ((c = e.assembleInfo) == null ? void 0 : c.needHandleNewList) || [], "old-assemble-list": ((m = e.assembleInfo) == null ? void 0 : m.needHandleOldList) || [], assembleInfo: e.assembleInfo, "only-show": "" }, null, 8, ["new-assemble-list", "old-assemble-list", "assembleInfo"])])) : r("", true), (b = e.assembleCompareList) != null && b.length ? (t(), n("div", G, [a[2] || (a[2] = s("div", { class: "handle-title" }, [s("span", null, "# 部件变更信息")], -1)), l(o(H), { assembleCompareList: e.assembleCompareList, assembleInfo: e.assembleInfo }, null, 8, ["assembleCompareList", "assembleInfo"])])) : r("", true), (u = e.partCompareList) != null && u.length ? (t(), n("div", J, [a[3] || (a[3] = s("div", { class: "handle-title" }, [s("span", null, "# 零件变更信息")], -1)), l(o(O), { partCompareList: e.partCompareList }, null, 8, ["partCompareList"])])) : r("", true)], 64)) : r("", true)];
    }), _: 2 }, 1024))), 128))])], 4);
  };
} }, X = $(K, [["__scopeId", "data-v-bdd0de8f"]]);
export {
  X as default
};
