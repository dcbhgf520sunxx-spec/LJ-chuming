import { openBlock as e } from "vue";
import { createElementBlock as c } from "vue";
import { createBlock as a } from "vue";
import { createCommentVNode as r } from "vue";
import { Fragment as m } from "vue";
import { ElTableColumn as p } from "element-plus";
const _ = { __name: "enclosure", props: { basicClass: { type: Number }, columns: { type: Object } }, setup(s) {
  const o = s;
  return (u, i) => {
    var t, n;
    const l = p;
    return e(), c(m, null, [(t = o.columns) != null && t.visible("length") ? (e(), a(l, { key: "length", align: "center", label: "厚度（mm）", "min-width": "120px", prop: "length", "show-overflow-tooltip": "" })) : r("", true), (n = o.columns) != null && n.visible("brand") ? (e(), a(l, { key: "brand", align: "center", label: "品牌", prop: "brand", "show-overflow-tooltip": "" })) : r("", true)], 64);
  };
} };
export {
  _ as default
};
