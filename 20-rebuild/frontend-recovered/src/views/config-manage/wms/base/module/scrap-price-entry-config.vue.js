import { ref as o } from "vue";
import { inject as S } from "vue";
import { onMounted as B } from "vue";
import { resolveComponent as m } from "vue";
import { resolveDirective as D } from "vue";
import { openBlock as d } from "vue";
import { createBlock as p } from "vue";
import { withCtx as s } from "vue";
import { createElementVNode as f } from "vue";
import { withDirectives as P } from "vue";
import { createTextVNode as k } from "vue";
import { unref as _ } from "vue";
import { createVNode as i } from "vue";
import { ElNotification as v } from "element-plus";
import { ElFormItem as z } from "element-plus";
import { ElForm as T } from "element-plus";
import { ElCard as j } from "element-plus";
import { hc as F, hd as L, he as M } from "../../../../../shared/runtime.js";
import { u as R } from "../../../../../modules/use-refresh-store-3f8d2c0c.js";
const U = { class: "clearfix" }, H = { __name: "scrap-price-entry-config", setup(q) {
  const r = o(void 0), y = S("permission"), t = o(r.value), c = o(false), l = o(false), n = o(true);
  B(() => {
    u();
  });
  const u = async () => {
    c.value = true;
    try {
      const e = await F();
      console.log(e), t.value = e, r.value = e;
    } catch (e) {
      console.log("wms基础配置", e);
    } finally {
      c.value = false;
    }
  }, g = (e) => {
    t.value = e, e === r.value ? n.value = true : n.value = false;
  }, h = async () => {
    try {
      l.value = true, await M({ type: t.value }), v({ title: "废料价格录入设置成功", type: "success", duration: 2500 }), R("wmsConfig"), n.value = true, u();
    } catch {
      v({ title: "废料价格录入设置失败", type: "error", duration: 2500 });
    } finally {
      l.value = false;
    }
  };
  return (e, a) => {
    const b = m("common-tip-button"), w = m("common-radio"), C = z, E = T, V = j, x = D("permission");
    return d(), p(V, { shadow: "always" }, { header: s(() => [f("div", U, [a[2] || (a[2] = f("span", { class: "card-title" }, "废料价格录入", -1)), P((d(), p(b, { style: { float: "right" }, size: "default", type: "primary", loading: l.value, "show-tip": "", onClick: h, disabled: n.value }, { default: s(() => a[1] || (a[1] = [k(" 保存 ")])), _: 1, __: [1] }, 8, ["loading", "disabled"])), [[x, _(y).scrapPriceEdit]])])]), default: s(() => [i(E, null, { default: s(() => [i(C, { label: "录入时机" }, { default: s(() => [i(w, { modelValue: t.value, "onUpdate:modelValue": a[0] || (a[0] = (N) => t.value = N), options: _(L).ENUM, type: "enum", size: "default", onChange: g }, null, 8, ["modelValue", "options"])]), _: 1 })]), _: 1 })]), _: 1 });
  };
} };
export {
  H as default
};
