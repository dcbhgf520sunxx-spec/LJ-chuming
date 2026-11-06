import { _ as h } from "../../../modules/black-bg-05289b55.js";
import { e as N } from "../../../modules/qr-scan-info-657de68e.js";
import { useRoute as w } from "vue-router";
import { ref as u } from "vue";
import { ElLoading as A } from "element-plus";
import { openBlock as r } from "vue";
import { createElementBlock as i } from "vue";
import { createElementVNode as a } from "vue";
import { toDisplayString as o } from "vue";
import { createCommentVNode as c } from "vue";
import { Fragment as f } from "vue";
import { _ as q, s as B } from "../../../shared/runtime.js";
import "../../../modules/externalRequest-4308f5b0.js";
const L = { class: "app-container" }, M = { class: "title-drawer" }, R = { class: "info" }, C = { class: "info" }, E = { key: 0 }, S = { class: "info" }, D = { __name: "auxiliary-material", setup(P) {
  const n = w(), e = u({ name: "", specification: "", serialNumber: "", color: "", brand: "" }), y = n.query.id, g = n.query.factoryId, b = n.query.taskId, p = u(!!+n.query.sl), k = u(!!+n.query.sm), x = { id: y, factoryId: g, taskId: b }, m = window.location.href.split(B.QR_SCAN_AUXILIARY_MATERIAL)[0].split("/#")[0];
  console.log(m), I(m, x);
  async function I(d, s) {
    const l = A.service({ lock: true, text: "正在加载配套件信息", background: "rgba(0, 0, 0, 0.7)", fullscreen: true });
    try {
      const t = await N(d, s);
      e.value = t, console.log(e);
    } catch (t) {
      console.log("获取配套件信息失败", t);
    } finally {
      l.close();
    }
  }
  return (d, s) => {
    var l, t, _, v;
    return r(), i("div", L, [s[1] || (s[1] = a("img", { src: h, class: "img-bg" }, null, -1)), a("div", M, o(`${e.value.name} ${e.value.serialNumber}`), 1), s[2] || (s[2] = a("span", { class: "subtitle" }, " 基础信息 ", -1)), a("div", R, [a("span", null, "名称：" + o(e.value.name), 1), a("span", null, "编号：" + o(e.value.serialNumber), 1), a("span", null, "规格：" + o(e.value.specification), 1), a("span", null, "颜色：" + o(e.value.color), 1), a("span", null, "品牌：" + o(e.value.brand), 1)]), s[3] || (s[3] = a("span", { class: "subtitle" }, " 使用部位 ", -1)), a("div", C, [a("span", null, "项目：" + o((l = e.value.project) == null ? void 0 : l.shortName), 1), k.value ? (r(), i("span", E, "单体：" + o((t = e.value.monomer) == null ? void 0 : t.name), 1)) : c("", true)]), p.value ? (r(), i(f, { key: 0 }, [s[0] || (s[0] = a("span", { class: "subtitle" }, " 生产信息 ", -1)), a("div", S, [p.value ? (r(), i(f, { key: 0 }, [a("span", null, "工厂：" + o((_ = e.value.factory) == null ? void 0 : _.name), 1), a("span", null, "生产线：" + o((v = e.value.productionLine) == null ? void 0 : v.name), 1)], 64)) : c("", true)])], 64)) : c("", true)]);
  };
} }, T = q(D, [["__scopeId", "data-v-e145a4e2"]]);
export {
  T as default
};
