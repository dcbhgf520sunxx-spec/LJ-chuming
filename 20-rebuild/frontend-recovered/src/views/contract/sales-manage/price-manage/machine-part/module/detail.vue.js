import { resolveComponent as l } from "vue";
import { resolveDirective as w } from "vue";
import { openBlock as x } from "vue";
import { createBlock as D } from "vue";
import { withCtx as a } from "vue";
import { createVNode as e } from "vue";
import { createTextVNode as v } from "vue";
import { createElementVNode as y } from "vue";
import { toDisplayString as C } from "vue";
import { withDirectives as k } from "vue";
import { unref as o } from "vue";
import { ElTag as I } from "element-plus";
import { ElTableColumn as N } from "element-plus";
import { gt as T } from "../../../../../../shared/runtime.js";
const O = { __name: "detail", props: { detailInfo: { type: Object, default: () => {
} } }, setup(p) {
  const i = p, { crud: n, detail: m, CRUD: d } = T();
  d.HOOK.afterToDetail = () => {
    console.log(n);
  };
  function _() {
    n.cancelDetail();
  }
  return (V, r) => {
    const b = I, f = l("print-table"), t = N, g = l("common-table"), u = l("common-drawer"), h = w("permission");
    return x(), D(u, { visible: o(n).detailVisible, title: "散发制品详情", size: "70%", "before-close": _ }, { titleAfter: a(() => [e(b, { type: "warning", size: "large", effect: "plain" }, { default: a(() => {
      var s, c;
      return [r[0] || (r[0] = v("综合单价：")), y("span", null, C((s = i.detailInfo) != null && s.totalPrice ? (c = i.detailInfo) == null ? void 0 : c.totalPrice : "-"), 1)];
    }), _: 1, __: [0] })]), titleRight: a(() => [k(e(f, { "api-key": "machinePartDetail", params: i.detailInfo.id, size: "default" }, null, 8, ["params"]), [[h, o(n).permission.print]])]), content: a(() => [e(g, { data: o(m).content }, { default: a(() => [e(t, { label: "序号", type: "index", align: "center", width: "60" }), e(t, { prop: "name", label: "名称", "min-width": "100px", align: "center" }), e(t, { prop: "serialNumber", label: "编号", "min-width": "100px", align: "center" }), e(t, { prop: "specification", label: "规格", "min-width": "100px", align: "center" }), e(t, { prop: "material", label: "材质", "min-width": "100px", align: "center" }), e(t, { prop: "quantity", label: "数量", "min-width": "80px", align: "center" }), e(t, { prop: "netWeight", label: "单净重(kg)", "min-width": "100px", align: "center" })]), _: 1 }, 8, ["data"])]), _: 1 }, 8, ["visible"]);
  };
} };
export {
  O as default
};
