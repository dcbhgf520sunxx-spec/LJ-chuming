import p from "./module/header.vue.js";
import u from "./module/table.vue.js";
import { u as f } from "../../../modules/useSelect-654af12a.js";
import { _ as v, e6 as L } from "../../../shared/runtime.js";
import x from "./module/CreateGrant.vue.js";
import { ref as i } from "vue";
import { reactive as b } from "vue";
import { provide as r } from "vue";
import { openBlock as g } from "vue";
import { createElementBlock as h } from "vue";
import { createElementVNode as y } from "vue";
import { createVNode as o } from "vue";
import "../../../modules/contract-9b18cc88.js";
import "../../../modules/grant-managment-2c540b60.js";
import "./module/LookDetail.vue.js";
import "../../../modules/useTableTotal-3d22365a.js";
import "../../../modules/upload-file-download-812f558c.js";
const D = { class: "app-container" }, w = { class: "head-container" }, B = { __name: "index", setup(G) {
  const e = i(null), a = i(null), { projectLeaderList: n, allProjectList: l } = f(), s = b({ date: (/* @__PURE__ */ new Date()).getTime() });
  r("projectLeaderList", n), r("listFormData", s), r("allProjectList", l);
  const c = async () => {
    await a.value.getGrantList();
  }, m = (t) => {
    t === "reset" && L(s, { sustainable: ["date"] }), a.value.getGrantList();
  }, _ = () => {
    e.value.headerTitle = "创建授信", e.value.saveBtnTitle = "创建", e.value.visible = true;
  }, d = async (t) => {
    e.value.formData.id = t.id, e.value.headerTitle = "编辑授信", e.value.saveBtnTitle = "修改", await e.value.getGrantInfo(), e.value.visible = true;
  };
  return (t, T) => (g(), h("div", D, [y("div", w, [o(p, { onGetList: m, onOpenDrawer: _ })]), o(u, { ref_key: "tableRef", ref: a, onEditItem: d }, null, 512), o(x, { ref_key: "createRef", ref: e, onClose: c }, null, 512)]));
} }, $ = v(B, [["__scopeId", "data-v-6d4f3749"]]);
export {
  $ as default
};
