import { inject as u } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as r } from "vue";
import { createElementVNode as s } from "vue";
import { createVNode as o } from "vue";
import { withCtx as f } from "vue";
import { unref as t } from "vue";
import { createCommentVNode as _ } from "vue";
import { normalizeStyle as y } from "vue";
import { ElCard as h } from "element-plus";
import { _ as v } from "../../../../../../modules/artifact-change-summary-table-c696270c.js";
import { _ as L, a as g } from "../../../../../../modules/machine-part-change-table-207fbedf.js";
import { _ as C } from "../../../../../../shared/runtime.js";
import "../../../../../../modules/common-ac6e385c.js";
const b = { class: "left-con" }, x = { class: "box-content" }, S = { key: 0, class: "box-content" }, k = { key: 1, class: "box-content" }, w = { __name: "change-summary", props: { heightStyle: { type: String } }, setup(p) {
  const a = u("summaryInfo");
  return (B, e) => {
    const d = h;
    return n(), r("div", { class: "summary-content", style: y(p.heightStyle) }, [s("div", b, [o(d, null, { default: f(() => {
      var m, i, l, c;
      return [s("div", x, [e[0] || (e[0] = s("div", { class: "summary-title" }, [s("span", null, "# 构件汇总")], -1)), o(t(v), { artifactCompareList: t(a).artifactList || [] }, null, 8, ["artifactCompareList"])]), (i = (m = t(a)) == null ? void 0 : m.assembleList) != null && i.length ? (n(), r("div", S, [e[1] || (e[1] = s("div", { class: "summary-title" }, [s("span", null, "# 部件汇总")], -1)), o(t(L), { assembleCompareList: t(a).assembleList || [], showProcess: "" }, null, 8, ["assembleCompareList"])])) : _("", true), (c = (l = t(a)) == null ? void 0 : l.partList) != null && c.length ? (n(), r("div", k, [e[2] || (e[2] = s("div", { class: "summary-title" }, [s("span", null, "# 零件汇总")], -1)), o(t(g), { partCompareList: t(a).partList || [], showProcess: "" }, null, 8, ["partCompareList"])])) : _("", true)];
    }), _: 1 })])], 4);
  };
} }, P = C(w, [["__scopeId", "data-v-f75ddf75"]]);
export {
  P as default
};
