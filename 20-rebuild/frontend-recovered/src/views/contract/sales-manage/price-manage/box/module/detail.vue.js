import { ref as C } from "vue";
import { resolveComponent as c } from "vue";
import { openBlock as d } from "vue";
import { createBlock as p } from "vue";
import { withCtx as o } from "vue";
import { createVNode as e } from "vue";
import { createTextVNode as I } from "vue";
import { createElementVNode as k } from "vue";
import { toDisplayString as D } from "vue";
import { withDirectives as N } from "vue";
import { unref as l } from "vue";
import { ElTag as O } from "element-plus";
import { ElTableColumn as T } from "element-plus";
import { vLoading as B } from "element-plus";
import { o as E, gt as H } from "../../../../../../shared/runtime.js";
const L = { __name: "detail", props: { detailInfo: { type: Object, default: () => {
} } }, emits: ["refresh"], setup(m, { emit: _ }) {
  const g = _, f = m, { maxHeight: h } = E({ extraBox: ".el-drawer__header", wrapperBox: "", extraHeight: 4 }), n = C([]), { crud: i, detail: u, CRUD: r } = H();
  r.HOOK.beforeDetailLoaded = async (s) => {
    n.value = [];
    try {
      n.value = (u.content || []).map((t) => (t.rowId = Math.random(), t));
    } catch {
      s.notify("获取分段详情", r.NOTIFICATION_TYPE.ERROR);
    }
  };
  function b() {
    i.cancelDetail(), g("refresh");
  }
  return (s, t) => {
    const x = O, a = T, w = c("common-table"), y = c("common-drawer"), v = B;
    return d(), p(y, { "append-to-body": "", "close-on-click-modal": false, "before-close": b, visible: l(i).detailVisible, title: "详情", "show-close": true, size: "70%" }, { titleAfter: o(() => [e(x, { type: "warning", size: "large", effect: "plain" }, { default: o(() => [t[0] || (t[0] = I("综合单价：")), k("span", null, D(f.detailInfo.originUnitPrice), 1)]), _: 1, __: [0] })]), content: o(() => [N((d(), p(w, { data: n.value, "row-key": "rowId", "max-height": l(h) }, { default: o(() => [e(a, { label: "序号", type: "index", align: "center", width: "60" }), e(a, { prop: "serialNumber", label: "编号", "min-width": "100px", align: "center" }), e(a, { prop: "specification", label: "规格", "min-width": "100px", align: "center" }), e(a, { prop: "material", label: "材质", "min-width": "100px", align: "center" }), e(a, { prop: "quantity", label: "数量", "min-width": "80px", align: "center" }), e(a, { prop: "netWeight", label: "单净重(kg)", "min-width": "100px", align: "center" })]), _: 1 }, 8, ["data", "max-height"])), [[v, l(i).detailLoading]])]), _: 1 }, 8, ["visible"]);
  };
} };
export {
  L as default
};
