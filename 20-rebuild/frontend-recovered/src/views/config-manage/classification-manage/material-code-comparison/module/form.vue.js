import { ref as n } from "vue";
import { provide as F } from "vue";
import { computed as y } from "vue";
import { watch as M } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as u } from "vue";
import { createBlock as m } from "vue";
import { createSlots as T } from "vue";
import { withCtx as s } from "vue";
import { createVNode as d } from "vue";
import { unref as i } from "vue";
import { resolveDynamicComponent as U } from "vue";
import { createTextVNode as w } from "vue";
import { createCommentVNode as V } from "vue";
import { ElMessage as h } from "element-plus";
import { ElPopconfirm as D } from "element-plus";
import { ElForm as j } from "element-plus";
import { l as p, ao as z, cO as A } from "../../../../../shared/runtime.js";
import E from "./application/table/index.vue.js";
function P(o) {
  return p({ module: "config", url: "materialCodeConfig/record/raw-materials", method: "get", params: o });
}
function J(o) {
  return p({ url: "/api/config/materialCodeConfig/addBatch", method: "post", data: o });
}
function Q(o) {
  return p({ url: "/api/config/materialCodeConfig/updateBatch", method: "post", data: o });
}
const H = { get: P }, I = { __name: "form", setup(o) {
  const v = n(), b = n(), l = n(), L = {}, S = { basicClass: void 0, list: [], sectionSteelList: [], steelPlateList: [], steelCoilList: [], otherSteelMaterialList: [], auxiliaryMaterialList: [], otherList: [], gasList: [], otherBasicClassList: [] }, { CRUD: R, crud: e, form: a } = z(S);
  F("crud", e);
  const c = y(() => e.status.cu > R.STATUS.NORMAL), k = y(() => E), f = n(false);
  async function B() {
    var r;
    f.value = true;
    try {
      if (!((r = l.value) != null && r.validate())) return;
      e.status.edit ? await Q(a.list).then(async (t) => {
        t && (h.success("编辑成功"), await e.toQuery(), await e.cancelCU());
      }) : await J(a.list).then(async (t) => {
        t && (h.success("添加成功"), await e.toQuery(), await e.cancelCU());
      });
    } catch (t) {
      console.log(t);
    } finally {
      f.value = false;
    }
  }
  return M(() => c, async (r) => {
    e.status.edit && (a.list = e.selections, await A(a.list), r || e.resetForm(JSON.parse(JSON.stringify(a))));
  }, { deep: true }), (r, t) => {
    const _ = C("common-button"), x = D, N = j, O = C("common-drawer");
    return u(), m(O, { ref_key: "drawerRef", ref: v, "before-close": i(e).cancelCU, "content-loading": i(e).editDetailLoading, "show-close": true, title: i(e).status.title, visible: c.value, "custom-class": "profit-application-record-form", size: "70%" }, T({ titleRight: s(() => {
      var g;
      return [d(_, { loading: f.value, class: "filter-item", type: "primary", onClick: B }, { default: s(() => t[0] || (t[0] = [w(" 保 存 ")])), _: 1, __: [0] }, 8, ["loading"]), d(x, { title: "确认清空全部数据吗？", onConfirm: (g = l.value) == null ? void 0 : g.clearList }, { reference: s(() => [i(e).status.edit ? V("", true) : (u(), m(_, { key: 0, class: "filter-item", type: "danger" }, { default: s(() => t[1] || (t[1] = [w(" 清空 ")])), _: 1, __: [1] }))]), _: 1 }, 8, ["onConfirm"])];
    }), _: 2 }, [c.value ? { name: "content", fn: s(() => [d(N, { ref_key: "formRef", ref: b, model: i(a), rules: L, class: "form", inline: "", "label-position": "right", "label-width": "70px", size: "small" }, { default: s(() => [(u(), m(U(k.value), { ref_key: "compRef", ref: l }, null, 512))]), _: 1 }, 8, ["model"])]), key: "0" } : void 0]), 1032, ["before-close", "content-loading", "title", "visible"]);
  };
} }, K = Object.freeze(Object.defineProperty({ __proto__: null, default: I }, Symbol.toStringTag, { value: "Module" }));
export {
  I as _,
  H as c,
  K as f
};
