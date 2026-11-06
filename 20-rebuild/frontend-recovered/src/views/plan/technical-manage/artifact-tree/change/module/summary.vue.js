import { inject as f } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as n } from "vue";
import { createElementVNode as s } from "vue";
import { createVNode as e } from "vue";
import { withCtx as p } from "vue";
import { unref as t } from "vue";
import { createCommentVNode as d } from "vue";
import { normalizeStyle as y } from "vue";
import { ElCard as h } from "element-plus";
import { _ as v } from "../../../../../../modules/artifact-change-summary-table-c696270c.js";
import { _ as L, a as C } from "../../../../../../modules/machine-part-change-table-207fbedf.js";
import { a as b } from "../../../../../../modules/anchor-nav-b01bf51a.js";
import { _ as x } from "../../../../../../shared/runtime.js";
import "../../../../../../modules/common-ac6e385c.js";
const g = { class: "left-con anchor-container" }, S = { class: "box-content" }, k = { key: 0, class: "box-content" }, N = { key: 1, class: "box-content" }, w = { __name: "summary", props: { heightStyle: { type: String } }, setup(u) {
  const o = f("summaryInfo");
  return (B, a) => {
    const i = h;
    return r(), n("div", { class: "summary-content", style: y(u.heightStyle) }, [s("div", g, [e(i, null, { default: p(() => {
      var l, m, c, _;
      return [s("div", S, [a[0] || (a[0] = s("div", { class: "summary-title anchor-title" }, [s("span", null, "# 构件汇总")], -1)), e(t(v), { artifactCompareList: t(o).artifactList || [] }, null, 8, ["artifactCompareList"])]), (m = (l = t(o)) == null ? void 0 : l.assembleList) != null && m.length ? (r(), n("div", k, [a[1] || (a[1] = s("div", { class: "summary-title anchor-title" }, [s("span", null, "# 部件汇总")], -1)), e(t(L), { assembleCompareList: t(o).assembleList || [], showProcess: "" }, null, 8, ["assembleCompareList"])])) : d("", true), (_ = (c = t(o)) == null ? void 0 : c.partList) != null && _.length ? (r(), n("div", N, [a[2] || (a[2] = s("div", { class: "summary-title anchor-title" }, [s("span", null, "# 零件汇总")], -1)), e(t(C), { partCompareList: t(o).partList || [], showProcess: "" }, null, 8, ["partCompareList"])])) : d("", true)];
    }), _: 1 })]), e(i, { class: "right-con" }, { default: p(() => [e(b)]), _: 1 })], 4);
  };
} }, z = x(w, [["__scopeId", "data-v-6c27d39d"]]);
export {
  z as default
};
