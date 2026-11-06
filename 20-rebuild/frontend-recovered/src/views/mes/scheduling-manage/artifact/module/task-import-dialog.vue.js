import { ref as i } from "vue";
import { nextTick as R } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as T } from "vue";
import { createBlock as q } from "vue";
import { withCtx as o } from "vue";
import { createVNode as s } from "vue";
import { createTextVNode as y } from "vue";
import { createElementVNode as p } from "vue";
import { unref as f } from "vue";
import { ElUpload as C } from "element-plus";
import { isRef as L } from "vue";
import { ElMessage as N } from "element-plus";
import { ElFormItem as h } from "element-plus";
import { ElForm as j } from "element-plus";
import { t as z } from "../../../../../modules/common-a5dc7899.js";
import { u as D } from "../../../../../shared/runtime.js";
const M = { __name: "task-import-dialog", props: { visible: { type: Boolean, default: false }, query: { type: Object }, productType: { type: [Number, String] } }, emits: ["update:visible", "success"], setup(g, { emit: x }) {
  const m = x, l = g, { visible: r, handleClose: c } = D({ emit: m, props: l, field: "visible", showHook: k }), u = i(), d = i(false), _ = i({}), b = i([]);
  function k() {
    var t, e;
    _.value = { areaId: (e = (t = l.query) == null ? void 0 : t.areaIdList) == null ? void 0 : e[0], productType: l.productType }, R(() => {
      b.value = [], u.value.clearFiles();
    });
  }
  function w(t, e) {
    N.warning("当前限制选择 1 个文件");
  }
  async function V(t) {
    try {
      d.value = true;
      const e = t.file, a = new FormData();
      a.append("file", e);
      for (const n in l.data) a.append(n, l.data[n]);
      await z(a, _.value), m("success"), c();
    } catch (e) {
      console.log(e);
    } finally {
      d.value = false;
    }
  }
  function I() {
    var t;
    (t = u.value) == null || t.submit();
  }
  return (t, e) => {
    const a = v("common-button"), n = h, B = j, E = v("common-dialog");
    return T(), q(E, { title: "任务导入", modelValue: f(r), "onUpdate:modelValue": e[0] || (e[0] = (F) => L(r) ? r.value = F : null), width: "500px", "before-close": f(c) }, { titleRight: o(() => [s(a, { size: "default", type: "primary", onClick: I }, { default: o(() => e[1] || (e[1] = [y("确认下发")])), _: 1, __: [1] })]), default: o(() => [e[3] || (e[3] = p("div", { class: "red-tip", style: { "margin-bottom": "20px" } }, [p("span", null, "* 注意："), p("span", null, "此操作可将任务直接下发至生产组，请仔细核对表格数据！")], -1)), s(B, { "label-width": "110px", "label-position": "left" }, { default: o(() => [s(n, { label: "任务导入" }, { default: o(() => [s(f(C), { ref_key: "uploadRef", ref: u, action: "", accept: ".xls,.xlsx", "file-list": b.value, "http-request": V, "on-exceed": w, "auto-upload": false, limit: 1 }, { default: o(() => [s(a, { size: "default", loading: d.value, type: "warning" }, { default: o(() => e[2] || (e[2] = [y("选择文件")])), _: 1, __: [2] }, 8, ["loading"])]), _: 1 }, 8, ["file-list"])]), _: 1 })]), _: 1 })]), _: 1, __: [3] }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  M as default
};
