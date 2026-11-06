import { openBlock as e } from "vue";
import { createElementBlock as c } from "vue";
import { createBlock as t } from "vue";
import { createCommentVNode as l } from "vue";
import { Fragment as p } from "vue";
import { ElTableColumn as i } from "element-plus";
const _ = { __name: "structure", props: { basicClass: { type: Number }, columns: { type: Object } }, setup(s) {
  const o = s;
  return (u, b) => {
    var a, r, m;
    const n = i;
    return e(), c(p, null, [(a = o.columns) != null && a.visible("monomer.name") ? (e(), t(n, { key: "monomer.name", align: "center", label: "单体", "min-width": "120px", prop: "monomer.name", "show-overflow-tooltip": "" })) : l("", true), (r = o.columns) != null && r.visible("area.name") ? (e(), t(n, { key: "area.name", align: "center", label: "区域", "min-width": "120px", prop: "area.name", "show-overflow-tooltip": "" })) : l("", true), (m = o.columns) != null && m.visible("length") ? (e(), t(n, { key: "length", align: "center", label: "长度（mm）", "min-width": "120px", prop: "length", "show-overflow-tooltip": "" })) : l("", true)], 64);
  };
} };
export {
  _ as default
};
