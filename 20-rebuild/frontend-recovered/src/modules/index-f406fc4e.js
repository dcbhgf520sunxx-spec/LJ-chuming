import { d5 as m } from "../shared/runtime.js";
import { ref as u } from "vue";
import { resolveComponent as y } from "vue";
import { openBlock as b } from "vue";
import { createBlock as w } from "vue";
import { withCtx as g } from "vue";
import { createTextVNode as h } from "vue";
import { toDisplayString as x } from "vue";
import { ElNotification as S } from "element-plus";
const z = { __name: "index", props: { beforeDownload: { type: Function, default: void 0 }, header: { type: Object, default: () => {
} }, template: { type: Object, required: true }, title: { type: String }, filename: { type: String }, params: { type: null }, size: { type: String, default: "default" }, disabled: { type: Boolean, default: false }, btnName: { type: String, default: "下载" }, btnType: { type: String } }, emits: ["end"], setup(a, { emit: i }) {
  const l = i, e = a, n = u(false);
  async function s(t) {
    try {
      return await e.template.fetch(t) || {};
    } catch {
      throw new Error("加载下载数据失败");
    }
  }
  async function d() {
    if (typeof e.beforeDownload != "function" || e.beforeDownload() !== false) {
      n.value = true;
      try {
        let t = e.params;
        e.params instanceof Array || (t = [e.params]);
        for (const o of t) {
          const { header: r, footer: c, table: f, qrCode: p } = await s(o) || {};
          if (!await m({ title: e.title, filename: e.filename, header: r, footer: c, table: f, qrCode: p, config: e.template })) throw new Error("导出失败");
        }
        l("end");
      } catch (t) {
        S({ title: "导出失败", message: t, type: "error", duration: 2500 }), console.log("导出", t);
      } finally {
        n.value = false;
      }
    }
  }
  return (t, o) => {
    const r = y("common-button");
    return b(), w(r, { loading: n.value, size: a.size, disabled: a.disabled, icon: "el-icon-download", type: a.btnType, onClick: d }, { default: g(() => [h(x(e.btnName), 1)]), _: 1 }, 8, ["loading", "size", "disabled", "type"]);
  };
} };
export {
  z as _
};
