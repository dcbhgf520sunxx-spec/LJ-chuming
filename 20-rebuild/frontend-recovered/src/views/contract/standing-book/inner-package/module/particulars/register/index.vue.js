import { ref as s } from "vue";
import { inject as f } from "vue";
import { provide as x } from "vue";
import { watch as v } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as g } from "vue";
import { createVNode as n } from "vue";
import { withCtx as c } from "vue";
import { unref as p } from "vue";
import { createBlock as b } from "vue";
import { createTextVNode as k } from "vue";
import { createCommentVNode as y } from "vue";
import { ElButton as w } from "element-plus";
import { _ as D, G as I, a as B, l4 as C, ec as E } from "../../../../../../../shared/runtime.js";
import V from "./info.vue.js";
import { W as j } from "../../../../../../../modules/contract-9b18cc88.js";
import h from "../components/establish/capital.vue.js";
import "../../../../../../../modules/capital-de0d42db.js";
import "./UseDetailTable.vue.js";
import "../../../../../../../modules/useTableTotal-3d22365a.js";
import "./ClassifyTable.vue.js";
import "../../../../../../../modules/data-039b7fd9.js";
const A = { class: "box-container" }, N = { __name: "index", setup(P) {
  const r = s([]), l = f("parent_data"), { projectInfo: t } = l, d = async () => {
    try {
      const e = await C({ projectId: t.project.id });
      r.value = E([e], ["date"]);
    } catch (e) {
      console.error("获取注资百分比信息失败:getExpendIdDetail" + e);
    }
  };
  x("info_parent_data", { projectInfo: t, endLogTableData: r }), v(() => {
    var e;
    return (e = t == null ? void 0 : t.project) == null ? void 0 : e.id;
  }, async (e) => {
    await d();
  }, { immediate: true });
  const o = s(false), _ = () => {
    o.value = true;
  };
  return (e, a) => {
    const m = w;
    return i(), g("div", A, [n(V, null, { createDarwer: c(() => [p(I)(p(j).innerPackAge.register.add) ? (i(), b(m, { key: 0, type: "primary", onClick: _ }, { default: c(() => [n(B, { class: "icon", "icon-class": "contract-register" }), a[1] || (a[1] = k(" 创建注资 "))]), _: 1 })) : y("", true)]), _: 1 }), n(h, { visible: o.value, "onUpdate:visible": a[0] || (a[0] = (u) => o.value = u) }, null, 8, ["visible"])]);
  };
} }, K = D(N, [["__scopeId", "data-v-cb7a9c7a"]]);
export {
  K as default
};
